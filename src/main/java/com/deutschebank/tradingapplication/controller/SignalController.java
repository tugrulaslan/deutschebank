package com.deutschebank.tradingapplication.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signals")
public class SignalController {

    @PostMapping("/{id}")
    public ResponseEntity<String> accept(@PathVariable("id") int id) {
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
