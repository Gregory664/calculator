package com.calculator.service;

import com.calculator.dto.LogDTO;
import com.calculator.interfaces.LogService;
import com.calculator.mapper.LogMapper;
import com.calculator.repository.LogRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {
    private final LogRepository repository;
    private final LogMapper mapper = Mappers.getMapper(LogMapper.class);

    @Autowired
    public LogServiceImpl(LogRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(LogDTO logDTO) {
        repository.save(mapper.toLog(logDTO));
    }
}
