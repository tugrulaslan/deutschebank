package com.deutschebank.tradingapplication.service.signalprocessor;

import com.deutschebank.tradingapplication.dto.Signal;
import com.deutschebank.tradingapplication.service.downstreamservice.Algo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.then;


@ExtendWith(MockitoExtension.class)
public class SignalOneProcessorTest {

    @Mock
    private Algo algo;

    @InjectMocks
    private SignalOneProcessor processor;

    @Test
    void shouldProcessSignalOne() {
        //given
        Signal signal = Signal.SIGNAL_ONE;

        //when
        processor.process(signal);

        //then
        then(algo).should().setUp();
        then(algo).should().setAlgoParam(1,60);
        then(algo).should().performCalc();
        then(algo).should().submitToMarket();
        then(algo).should().doAlgo();
    }
}