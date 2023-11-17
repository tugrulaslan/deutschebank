package com.deutschebank.tradingapplication.controller;

import com.deutschebank.tradingapplication.dto.Signal;
import com.deutschebank.tradingapplication.service.SignalHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signals")
public class SignalController {

    private final SignalHandler signalHandler;

    public SignalController(SignalHandler signalHandler) {
        this.signalHandler = signalHandler;
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> accept(@PathVariable("id") int id) {
        signalHandler.handle(Signal.retrieveSignal(id));
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
