package com.sanitas.calculadora.services;

import com.sanitas.calculadora.services.dto.CalculationResult;
import com.sanitas.calculadora.validators.CalculatorValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class CalculatorServiceImpl implements CalculatorService {

    CalculatorValidator calculatorValidator;

    public CalculatorServiceImpl(CalculatorValidator calculatorValidator) {
        this.calculatorValidator = calculatorValidator;
    }

    @Override
    public CalculationResult add(Float firstOperator, Float secondOperator) {
        log.info("CalulatorService Add method");

        Float result = firstOperator + secondOperator;
        return new CalculationResult(result);
    }

    @Override
    public CalculationResult subtraction(Float firstOperator, Float secondOperator) {
        log.info("CalculatorService Subtraction method");

        Float result = firstOperator - secondOperator;
        return new CalculationResult(result);
    }

    @Override
    public CalculationResult division(Float firstOpetator, Float secondOperator) {
        log.info("CalculatorService division method");

        calculatorValidator.validateIsDividedByZero(secondOperator);

        Float result = firstOpetator / secondOperator;
        return new CalculationResult(result);
    }
}
