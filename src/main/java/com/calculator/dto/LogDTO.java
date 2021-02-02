package com.calculator.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
public class LogDTO {
    private long id;
    private String expression;
    private Date callDate;
    private double result;
}
