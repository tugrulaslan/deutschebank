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
public class DefaultSignalProcessorTest {

    @Mock
    private Algo algo;

    @InjectMocks
    private DefaultSignalProcessor defaultSignalProcessor;

    @Test
    void shouldProcessDefaultSignal() {
        //given
        Signal signal = Signal.DEFAULT;

        //when
        defaultSignalProcessor.process(signal);

        //then
        then(algo).should().cancelTrades();
        then(algo).should().doAlgo();
    }
}