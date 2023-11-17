package com.deutschebank.tradingapplication.service.signalprocessor;

import com.deutschebank.tradingapplication.dto.Signal;
import com.deutschebank.tradingapplication.service.downstreamservice.Algo;
import org.springframework.stereotype.Service;

@Service
public class DefaultSignalProcessor extends AbstractSignalProcessor {

    private final Algo algo;

    public DefaultSignalProcessor(Algo algo) {
        super(algo);
        this.algo = algo;
    }

    @Override
    public Signal signalType() {
        return Signal.DEFAULT;
    }

    @Override
    public void processInternally(Signal signal) {
        algo.cancelTrades();
    }
}
