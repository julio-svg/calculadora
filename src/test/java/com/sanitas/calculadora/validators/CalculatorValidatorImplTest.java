package com.sanitas.calculadora.validators;

import com.sanitas.calculadora.exceptions.CannotBeDividedByZeroException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class CalculatorValidatorImplTest {

    @InjectMocks
    CalculatorValidatorImpl validator;

    @Test
    @DisplayName("Call ok to validateIsOperatorsArePositive method")
    void given_OkPetitionWhen_validateIsOperatorsArePositiveMethodThen_NoResponseOk(){
        validator.validateIsDividedByZero(2F);

    }


    @Test
    @DisplayName("Call ko to validateIsOperatorsArePositive method")
    void given_OkPetitionWhen_SubtractionMethodThen_MustBePositiveException(){
        assertThrows(CannotBeDividedByZeroException.class,() -> validator.validateIsDividedByZero(0F));

    }
}