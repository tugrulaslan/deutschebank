package com.deutschebank.tradingapplication.service.signalprocessor;

import com.deutschebank.tradingapplication.dto.Signal;
import com.deutschebank.tradingapplication.service.downstreamservice.Algo;
import org.springframework.stereotype.Service;

@Service
public class SignalThreeProcessor extends AbstractSignalProcessor {
    private final Algo algo;

    public SignalThreeProcessor(Algo algo) {
        super(algo);
        this.algo = algo;
    }

    @Override
    public Signal signalType() {
        return Signal.SIGNAL_THREE;
    }

    @Override
    public void processInternally(Signal signal) {
        algo.setAlgoParam(1, 90);
        algo.setAlgoParam(2, 15);
        algo.performCalc();
        algo.submitToMarket();
    }
}
