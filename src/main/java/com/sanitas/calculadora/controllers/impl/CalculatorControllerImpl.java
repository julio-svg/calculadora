package com.sanitas.calculadora.controllers.impl;


import com.sanitas.calculadora.controllers.CalculatorController;
import com.sanitas.calculadora.controllers.dto.CalculationResultDTO;
import com.sanitas.calculadora.services.CalculatorService;
import com.sanitas.calculadora.services.mapper.CalculationResultMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("calculator/v0")
@Slf4j
public class CalculatorControllerImpl implements CalculatorController {

    private final CalculatorService calculatorService;

    private final CalculationResultMapper calculationResultMapper;

    public CalculatorControllerImpl(CalculatorService calculatorService, CalculationResultMapper calculationResultMapper) {
        this.calculatorService = calculatorService;
        this.calculationResultMapper = calculationResultMapper;

    }

    @GetMapping("/add")
    @Override
    public ResponseEntity<CalculationResultDTO> add(@RequestParam Float firstOpetator, @RequestParam Float secondOperator) {

        log.info("CalculatorController add method");

        CalculationResultDTO result = calculationResultMapper.toDto(calculatorService.add(firstOpetator,secondOperator));

        HttpStatus httpStatus;

        if(ObjectUtils.isEmpty(result)){
            httpStatus = HttpStatus.NO_CONTENT;
        } else {
            httpStatus = HttpStatus.OK;
        }

        ResponseEntity<CalculationResultDTO> response = new ResponseEntity<>(result,httpStatus);
        return response;
    }

    @GetMapping("/subtraction")
    @Override
    public ResponseEntity<CalculationResultDTO> subtraction(Float firstOpetator, Float secondOperator) {

        log.info("CalculatorController subtraction method");

        CalculationResultDTO result = calculationResultMapper.toDto(calculatorService.subtraction(firstOpetator,secondOperator));

        HttpStatus httpStatus;

        if(ObjectUtils.isEmpty(result)){
            httpStatus = HttpStatus.NO_CONTENT;
        } else {
            httpStatus = HttpStatus.OK;
        }

        ResponseEntity<CalculationResultDTO> response = new ResponseEntity<>(result,httpStatus);
        return response;
    }

    @Override
    @GetMapping("/division")
    public ResponseEntity<CalculationResultDTO> division(Float firstOpetator, Float secondOperator) {
        log.info("CalculatorController division method");

        CalculationResultDTO result = calculationResultMapper.toDto(calculatorService.division(firstOpetator,secondOperator));

        HttpStatus httpStatus;

        if(ObjectUtils.isEmpty(result)){
            httpStatus = HttpStatus.NO_CONTENT;
        } else {
            httpStatus = HttpStatus.OK;
        }

        ResponseEntity<CalculationResultDTO> response = new ResponseEntity<>(result,httpStatus);

        return response;
    }


}
