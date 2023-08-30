package com.sanitas.calculadora.impl;

import com.sanitas.calculadora.exceptions.CannotBeDividedByZeroException;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class CalculatorControllerImplIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName(value = "Test 1: given two correct operators, call the addition operation and get an ok with the result.")
    void given_OkParametersWhen_tryToAddThen_get200AndResult() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/calculator/v0/add")
                        .param("firstOpetator", "5")
                        .param("secondOperator", "6")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.result", Matchers.is(11.0)));

    }


    @Test
    @DisplayName(value = "Test 2: given two correct operators, call the subtraction operation and get an ok with the result.")
    void given_OkParametersWhen_tryToSubtractionThen_get200AndResult() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/calculator/v0/subtraction")
                        .param("firstOpetator", "5")
                        .param("secondOperator", "3")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.result", Matchers.is(2.0)));

    }

    @Test
    @DisplayName(value = "Test 3: given two correct operators, call the division operation and get an ok with the result.")
    void given_OkParametersWhen_tryToDivisionThen_get200AndResult() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/calculator/v0/division")
                        .param("firstOpetator", "10")
                        .param("secondOperator", "2")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.result", Matchers.is(5.0)));

    }

    @Test
    @DisplayName(value = "Test 4: Given a 0 divisor(secondOperator) , the error CannotBeDividedByZeroException is obtained.")
    void given_NegativeParameterWhen_tryToSubtractionThen_get400AndMustBePositiveException() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/calculator/v0/division")
                        .param("firstOpetator", "5")
                        .param("secondOperator", "0")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof CannotBeDividedByZeroException));

    }

}