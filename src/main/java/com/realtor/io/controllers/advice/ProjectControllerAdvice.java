package com.realtor.io.controllers.advice;

import com.realtor.io.exceptions.ProjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
@ControllerAdvice
public class ProjectControllerAdvice extends ResponseEntityExceptionHandler {
        @ExceptionHandler(ProjectNotFoundException.class)
        public ResponseEntity<?> handleProjectNotFoundException(
                ProjectNotFoundException ex, WebRequest request) {

            Map<String, Object> body = new LinkedHashMap<>();
            body.put("timestamp", LocalDateTime.now());
            body.put("message", ex.getMessage());

            return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        }
}
