package com.sanitas.calculadora.controllers;

import com.sanitas.calculadora.controllers.dto.CalculationResultDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public interface CalculatorController {

    ResponseEntity<CalculationResultDTO> add(@RequestParam Float firstOpetator,@RequestParam Float secondOperator);

    ResponseEntity<CalculationResultDTO> subtraction(@RequestParam Float firstOpetator,@RequestParam Float secondOperator);

    ResponseEntity<CalculationResultDTO> division(@RequestParam Float firstOpetator,@RequestParam Float secondOperator);

}
