package com.testSevice.error;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ErrorInfo {
    String message;
    HttpStatus status;
}
