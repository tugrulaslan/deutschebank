package com.deutschebank.tradingapplication.dto;

import java.util.Arrays;

public enum Signal {
    SIGNAL_ONE(1),
    SIGNAL_TWO(2),
    SIGNAL_THREE(3),
    DEFAULT(null);

    private final Integer signalNo;

    Signal(Integer signalNo) {
        this.signalNo = signalNo;
    }

    public Integer getSignalNo() {
        return signalNo;
    }

    public static Signal retrieveSignal(Integer givenSignal) {

        return Arrays.stream(values())
                .filter(s -> s.signalNo !=null && s.signalNo.equals(givenSignal))
                .findFirst()
                .orElseGet(() -> DEFAULT);
    }
}
