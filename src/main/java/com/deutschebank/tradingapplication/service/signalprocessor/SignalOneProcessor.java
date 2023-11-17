package com.deutschebank.tradingapplication.service.signalprocessor;

import com.deutschebank.tradingapplication.dto.Signal;
import com.deutschebank.tradingapplication.service.downstreamservice.Algo;
import org.springframework.stereotype.Service;

@Service
public class SignalOneProcessor extends AbstractSignalProcessor {
    private final Algo algo;

    public SignalOneProcessor(Algo algo) {
        super(algo);
        this.algo = algo;
    }

    @Override
    public Signal signalType() {
        return Signal.SIGNAL_ONE;
    }

    @Override
    public void processInternally(Signal signal) {
        algo.setUp();
        algo.setAlgoParam(1, 60);
        algo.performCalc();
        algo.submitToMarket();
    }
}
