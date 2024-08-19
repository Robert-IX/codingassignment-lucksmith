package com.github.Robert_IX.codingassignment_lucksmith.exceptions;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import com.github.Robert_IX.codingassignment_lucksmith.controller.OrderController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

@WebMvcTest(OrderController.class)
public class ExceptionsTest
{

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private KieSession kieSession;

    @Test
    public void testException() throws Exception
    {
        when(kieSession.fireAllRules()).thenThrow(new RuntimeException("Internal server error"));

        mockMvc.perform(post("/api/rules/execute")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Test\", \"cardType\":\"A\", \"price\":5000}"))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("Internal server error"));
    }

    @Test
    public void testHandleIllegalArgumentException() throws Exception
    {
        when(kieSession.fireAllRules()).thenThrow(new IllegalArgumentException("Invalid input"));

        mockMvc.perform(post("/api/rules/execute")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Test\", \"cardType\":\"InvalidCard\", \"price\":5000}"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Invalid input"));
    }
}
