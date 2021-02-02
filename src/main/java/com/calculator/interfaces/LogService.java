package com.calculator.interfaces;

import com.calculator.dto.LogDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface LogService {
    boolean save(LogDTO logDTO);
}
