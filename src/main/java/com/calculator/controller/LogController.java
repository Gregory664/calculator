package com.calculator.controller;

import com.calculator.dto.LogDTO;
import com.calculator.exception.LogByExpressionNotFound;
import com.calculator.interfaces.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @RequestMapping(value = "/logs/callDate", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LogDTO> getByDateBetween(@RequestParam("start") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
                                         @RequestParam("end") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
        return logService.findByCallDateBetween(startDate, endDate);
    }


}
