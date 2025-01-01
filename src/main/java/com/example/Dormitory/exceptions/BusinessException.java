package com.example.Dormitory.exceptions;

import lombok.Data;

@Data
public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }

}
