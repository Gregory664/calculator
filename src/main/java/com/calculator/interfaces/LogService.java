package com.calculator.interfaces;

import com.calculator.dto.LogDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface LogService {
    void save(LogDTO logDTO);
}
