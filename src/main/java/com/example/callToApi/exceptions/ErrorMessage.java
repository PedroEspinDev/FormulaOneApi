package com.example.callToApi.exceptions;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ErrorMessage {
        private int statusCode;
        private Date timestamp;
        private String message;
        private String description;

}
