package com.calculator.mapper;

import com.calculator.dto.LogDTO;
import com.calculator.entity.Log;
import org.mapstruct.Mapper;

@Mapper
public interface LogMapper {
    LogDTO toDTO(Log log);

    Log toLog(LogDTO logDTO);
}
