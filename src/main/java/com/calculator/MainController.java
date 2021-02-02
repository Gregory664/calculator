package com.calculator;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MainController {

    @RequestMapping(value = "/calc", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public double calculate(@RequestParam("expression") String expression) {
        return APICalculator.calculate(expression);
    }
}
