package com.calculator.service;

import com.calculator.dto.LogDTO;
import com.calculator.interfaces.LogService;
import com.calculator.mapper.LogMapper;
import com.calculator.repository.LogRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public List<LogDTO> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<LogDTO> findByExpression(String expression) {
        return repository.findByExpression(expression).map(mapper::toDTO);
    }
}
