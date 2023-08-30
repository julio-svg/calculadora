package com.sanitas.calculadora.impl;

import com.sanitas.calculadora.controllers.dto.CalculationResultDTO;
import com.sanitas.calculadora.controllers.impl.CalculatorControllerImpl;
import com.sanitas.calculadora.services.CalculatorServiceImpl;
import com.sanitas.calculadora.services.dto.CalculationResult;
import com.sanitas.calculadora.services.mapper.CalculationResultMapper;
import io.corp.calculator.TracerImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class CalculatorControllerImplTest {

    @InjectMocks
    CalculatorControllerImpl calculatorController;

    @Mock
    CalculatorServiceImpl calculatorService;

    @Mock
    CalculationResultMapper calculationResultMapper;

    @Mock
    TracerImpl tracer;


    @Test
    @DisplayName("The request is ok and the add method responds with content.")
    void given_OkRequestWhen_AddMethodResponseWithContentThen_200Ok() {

        CalculationResultDTO calculationResultDTO = new CalculationResultDTO();
        calculationResultDTO.setResult(3F);
        CalculationResult calculationResult = new CalculationResult(3F);

        Mockito.when(calculatorService.add(Mockito.any(),Mockito.any())).thenReturn(calculationResult);
        Mockito.when(calculationResultMapper.toDto(Mockito.any(CalculationResult.class))).thenReturn(calculationResultDTO);

        ResponseEntity<CalculationResultDTO> result = calculatorController.add(1F, 2F);
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assertions.assertEquals(3F,result.getBody().getResult());
    }

    @Test
    @DisplayName("The request is ok and the add method responds without content.")
    void given_OkRequestWhen_AddMethodResponseWithContentThen_204Ok() {

        ResponseEntity<CalculationResultDTO> result = calculatorController.add(1F, 2F);
        Assertions.assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());
    }


    @Test
    @DisplayName("The request is ok and the subtract method responds with content.")
    void given_OkRequestWhen_SubtractMethodResponseWithContentThen_200Ok() {

        CalculationResultDTO calculationResultDTO = new CalculationResultDTO();
        calculationResultDTO.setResult(2F);
        CalculationResult calculationResult = new CalculationResult(2F);

        Mockito.when(calculatorService.subtraction(Mockito.any(),Mockito.any())).thenReturn(calculationResult);
        Mockito.when(calculationResultMapper.toDto(Mockito.any(CalculationResult.class))).thenReturn(calculationResultDTO);

        ResponseEntity<CalculationResultDTO> result = calculatorController.subtraction(3F, 1F);
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assertions.assertEquals(2F,result.getBody().getResult());
    }

    @Test
    @DisplayName("The request is ok and the subtract method responds without content.")
    void given_OkRequestWhen_SubtractMethodResponseWithContentThen_204Ok() {

        ResponseEntity<CalculationResultDTO> result = calculatorController.subtraction(1F, 2F);
        Assertions.assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());
    }

}
