package com.deutschebank.tradingapplication.service;

import com.deutschebank.tradingapplication.dto.Signal;
import com.deutschebank.tradingapplication.service.signalprocessor.SignalOneProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static java.util.List.of;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
public class SignalHandlerTest {

    private Signal signal = Signal.SIGNAL_ONE;

    @Mock
    private SignalOneProcessor processor;

    private SignalHandler handler;

    @BeforeEach
    void setUp() {
        given(processor.signalType()).willReturn(signal);
        handler = new SignalHandler(of(processor));
    }

    @Test
    void shouldHandleSignal() {
        //given - when
        handler.handle(signal);

        //then
        then(processor).should().process(signal);
    }
}