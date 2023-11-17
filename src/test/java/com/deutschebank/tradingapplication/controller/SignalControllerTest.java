package com.deutschebank.tradingapplication.controller;

import com.deutschebank.tradingapplication.TradingapplicationApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = {TradingapplicationApplication.class}, webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class SignalControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldThrowExceptionWhenGivenSignalIdIsBad() throws Exception {
        //given-when-then
        mockMvc.perform(post("/signals/abc"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldAcceptSignalRequestSuccessfully() throws Exception {
        //given-when-then
        mockMvc.perform(post("/signals/1"))
                .andDo(print())
                .andExpect(status().isAccepted());
    }
}
