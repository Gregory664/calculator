package com.calculator.interfaces;

import com.calculator.entity.Log;
import org.springframework.stereotype.Repository;

@Repository
public interface LogService {
    boolean save(Log log);
}
