package com.sanitas.calculadora.validators;

import com.sanitas.calculadora.exceptions.CannotBeDividedByZeroException;
import org.springframework.stereotype.Component;

@Component
public class CalculatorValidatorImpl implements CalculatorValidator{

    private static final float CTE_ZERO = 0;

    public void validateIsDividedByZero(Float secondOperator) throws RuntimeException{
            if(secondOperator == CTE_ZERO){
                throw new CannotBeDividedByZeroException("Operator 2 cannot be 0. secondOperator: " + secondOperator );
            }
    }
}
