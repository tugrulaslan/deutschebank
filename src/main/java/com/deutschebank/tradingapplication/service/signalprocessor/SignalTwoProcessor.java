package com.deutschebank.tradingapplication.service.signalprocessor;

import com.deutschebank.tradingapplication.dto.Signal;
import com.deutschebank.tradingapplication.service.downstreamservice.Algo;
import org.springframework.stereotype.Service;

@Service
public class SignalTwoProcessor extends AbstractSignalProcessor {
    private final Algo algo;

    public SignalTwoProcessor(Algo algo) {
        super(algo);
        this.algo = algo;
    }

    @Override
    public Signal signalType() {
        return Signal.SIGNAL_TWO;
    }

    @Override
    public void processInternally(Signal signal) {
        algo.reverse();
        algo.setAlgoParam(1,80);
        algo.submitToMarket();
    }
}
