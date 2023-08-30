package com.sanitas.calculadora.services;

import com.sanitas.calculadora.services.dto.CalculationResult;

public interface CalculatorService {

    CalculationResult add(Float firstOperator, Float secondOperator);
    CalculationResult subtraction(Float firstOperator, Float secondOperator);
    CalculationResult division(Float firstOpetator, Float secondOperator);
}
