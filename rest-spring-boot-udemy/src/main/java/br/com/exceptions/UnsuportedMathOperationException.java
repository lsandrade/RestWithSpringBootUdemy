package br.com.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsuportedMathOperationException extends RuntimeException{
    private static final long serialVersionID = 1L;

    public UnsuportedMathOperationException(String exception) {
        super(exception);
    }
}
