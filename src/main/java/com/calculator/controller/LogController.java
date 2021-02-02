package com.calculator.controller;

import com.calculator.dto.LogDTO;
import com.calculator.exception.LogByExpressionNotFound;
import com.calculator.interfaces.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LogController {
    private final LogService logService;

    @Autowired
    public LogController(LogService logService) {
        this.logService = logService;
    }

    @RequestMapping(value = "/logs", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LogDTO> getAll() {
        return logService.findAll();
    }

    @RequestMapping(value = "/logs/expressions/{exp}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public LogDTO getByExpression(@PathVariable("exp") String expression) {
        return logService.findByExpression(expression).orElseThrow(() -> new LogByExpressionNotFound(expression));
    }


}
