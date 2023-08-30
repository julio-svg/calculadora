package com.sanitas.calculadora.services.mapper;

import com.sanitas.calculadora.controllers.dto.CalculationResultDTO;
import com.sanitas.calculadora.services.dto.CalculationResult;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CalculationResultMapper extends EntityMapper<CalculationResultDTO, CalculationResult>
{

}
