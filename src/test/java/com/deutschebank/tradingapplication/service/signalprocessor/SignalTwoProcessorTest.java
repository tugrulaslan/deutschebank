package com.deutschebank.tradingapplication.service.signalprocessor;

import com.deutschebank.tradingapplication.dto.Signal;
import com.deutschebank.tradingapplication.service.downstreamservice.Algo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.then;


@ExtendWith(MockitoExtension.class)
class SignalTwoProcessorTest {

    @Mock
    private Algo algo;

    @InjectMocks
    private SignalTwoProcessor processor;

    @Test
    void shouldProcessSignalTwo() {
        //given
        Signal signal = Signal.SIGNAL_TWO;

        //when
        processor.process(signal);

        //then
        assertThat(processor.signalType()).isEqualTo(signal);
        then(algo).should().reverse();
        then(algo).should().setAlgoParam(1, 80);
        then(algo).should().submitToMarket();
        then(algo).should().doAlgo();
    }
}