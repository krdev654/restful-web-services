package com.sample.mydash.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Date;

@Data
@AllArgsConstructor
public class ErrorResponse {

    private Date timestamp;
    private String message;
    private String details;
}
