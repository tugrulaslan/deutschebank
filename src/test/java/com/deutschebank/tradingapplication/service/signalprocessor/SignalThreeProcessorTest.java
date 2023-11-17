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
class SignalThreeProcessorTest {

    @Mock
    private Algo algo;

    @InjectMocks
    private SignalThreeProcessor processor;

    @Test
    void shouldProcessSignalThree() {
        //given
        Signal signal = Signal.SIGNAL_THREE;

        //when
        processor.process(signal);

        //then
        assertThat(processor.signalType()).isEqualTo(signal);
        then(algo).should().setAlgoParam(1, 90);
        then(algo).should().setAlgoParam(2, 15);
        then(algo).should().performCalc();
        then(algo).should().submitToMarket();
        then(algo).should().doAlgo();
    }
}