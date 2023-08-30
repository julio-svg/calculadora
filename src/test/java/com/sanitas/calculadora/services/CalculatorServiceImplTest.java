package com.sanitas.calculadora.services;


import com.sanitas.calculadora.services.dto.CalculationResult;
import com.sanitas.calculadora.validators.CalculatorValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class CalculatorServiceImplTest {

    @InjectMocks
    CalculatorServiceImpl calculatorService;

    @Mock
    CalculatorValidator calculatorValidator;

    @Test
    @DisplayName("Call ok to add method")
    void given_OkPetitionWhen_AddMethodResponseOk(){
        CalculationResult result = calculatorService.add(2F,2F);
        Assertions.assertEquals(4F,result.getResult());
    }


    @Test
    @DisplayName("Call ok to subtraction method")
    void given_OkPetitionWhen_SubtractionMethodResponseOk(){
        CalculationResult result = calculatorService.subtraction(2F,2F);
        Assertions.assertEquals(0F,result.getResult());
    }

    @Test
    @DisplayName("Call ok to division method")
    void given_OkPetitionWhen_DivisionMethodResponseOk(){
        CalculationResult result = calculatorService.division(2F,2F);
        Assertions.assertEquals(1F,result.getResult());
    }
}
