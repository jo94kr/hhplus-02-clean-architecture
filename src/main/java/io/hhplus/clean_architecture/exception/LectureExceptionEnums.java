package io.hhplus.clean_architecture.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class LectureExceptionEnums {

    @Getter
    @RequiredArgsConstructor
    public enum Exception implements ExceptionInterface {
        ALREADY_EXISTS("lecture is already exist."),
        MAX_CAPACITY("lecture capacity exceeded."),
        BEFORE_START_DATE("before the start date."),
        ;

        private final String message;
    }
}
