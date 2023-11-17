package com.deutschebank.tradingapplication.service;

import com.deutschebank.tradingapplication.dto.Signal;
import com.deutschebank.tradingapplication.service.signalprocessor.AbstractSignalProcessor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SignalHandler {
    private final Map<Signal, AbstractSignalProcessor> suppliers = new HashMap<>();

    public SignalHandler(List<AbstractSignalProcessor> supplierList) {
        supplierList.forEach(supplier -> suppliers.put(supplier.signalType(), supplier));
    }

    public void handle(Signal signal) {
        AbstractSignalProcessor supplier = suppliers.get(signal);
        supplier.process(signal);
    }
}
