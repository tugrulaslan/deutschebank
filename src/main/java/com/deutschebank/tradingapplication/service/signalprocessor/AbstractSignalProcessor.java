package com.deutschebank.tradingapplication.service.signalprocessor;

import com.deutschebank.tradingapplication.dto.Signal;
import com.deutschebank.tradingapplication.service.downstreamservice.Algo;
import org.springframework.stereotype.Service;

@Service
public abstract class AbstractSignalProcessor {

    private final Algo algo;

    public AbstractSignalProcessor(Algo algo) {
        this.algo = algo;
    }

    public void process(Signal signal){
        processInternally(signal);
        algo.doAlgo();
    }

    public abstract Signal signalType();

    abstract void processInternally(Signal signal);
}
