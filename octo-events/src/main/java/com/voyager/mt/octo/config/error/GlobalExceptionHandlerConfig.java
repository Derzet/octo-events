package com.voyager.mt.octo.config.error;

import com.voyager.mt.octo.config.error.exception.EventNotFoundException;
import com.voyager.mt.octo.config.error.exception.IssueNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.WebUtils;

import java.util.Collections;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandlerConfig {

    @ExceptionHandler({EventNotFoundException.class, IssueNotFoundException.class})
    public final ResponseEntity<ApiError> handleException(Exception exeception, WebRequest request) {
        HttpHeaders headers = new HttpHeaders();

        if (exeception instanceof EventNotFoundException) {
            HttpStatus status = HttpStatus.NOT_FOUND;
            EventNotFoundException eventNotFoundException = (EventNotFoundException) exeception;
            return handleEventNotFoundException(eventNotFoundException, headers, status, request);
        }else if(exeception instanceof IssueNotFoundException) {
            HttpStatus status = HttpStatus.NOT_FOUND;
            IssueNotFoundException issueNotFoundException = (IssueNotFoundException) exeception;
            return handleEventNotFoundException(issueNotFoundException, headers, status, request);
        }else{
            HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
            return handleExceptionInternal(exeception, null, headers, status, request);
        }
    }


    protected ResponseEntity<ApiError> handleEventNotFoundException(EventNotFoundException eventNotFoundException, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errors = Collections.singletonList(eventNotFoundException.getMessage());
        return handleExceptionInternal(eventNotFoundException, new ApiError(errors, status), headers, status, request);
    }

    protected ResponseEntity<ApiError> handleEventNotFoundException(IssueNotFoundException issueNotFoundException, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errors = Collections.singletonList(issueNotFoundException.getMessage());
        return handleExceptionInternal(issueNotFoundException, new ApiError(errors, status), headers, status, request);
    }

    protected ResponseEntity<ApiError> handleExceptionInternal(Exception ex, ApiError body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
        }

        return ResponseEntity.status(status.value()).headers(headers).body(body);
    }


}
