package com.calculator.interfaces;

import com.calculator.dto.LogDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LogService {
    void save(LogDTO logDTO);

    List<LogDTO> findAll();

    Optional<LogDTO> findByExpression(String expression);
}
