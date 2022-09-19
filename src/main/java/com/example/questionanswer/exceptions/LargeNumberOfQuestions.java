package com.example.questionanswer.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class LargeNumberOfQuestions extends  RuntimeException {
    public LargeNumberOfQuestions() {
    }

    public LargeNumberOfQuestions(String message) {
        super(message);
    }

    public LargeNumberOfQuestions(String message, Throwable cause) {
        super(message, cause);
    }

    public LargeNumberOfQuestions(Throwable cause) {
        super(cause);
    }

    public LargeNumberOfQuestions(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
