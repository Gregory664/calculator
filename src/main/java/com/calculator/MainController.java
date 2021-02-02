package com.calculator;

import com.calculator.dto.LogDTO;
import com.calculator.interfaces.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.time.LocalDate;

@RestController
@RequestMapping("/api")
public class MainController {
    private final LogService logService;

    @Autowired
    public MainController(LogService logService) {
        this.logService = logService;
    }

    @RequestMapping(value = "/calc", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public double calculate(@RequestParam("expression") String expression) {
        double result = APICalculator.calculate(expression);
        LogDTO logDTO = LogDTO.builder()
                .expression(expression)
                .callDate(Date.valueOf(LocalDate.now()))
                .result(result)
                .build();
        logService.save(logDTO);
        return result;
    }
}
