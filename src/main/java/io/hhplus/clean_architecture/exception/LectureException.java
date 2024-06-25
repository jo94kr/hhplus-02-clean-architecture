package io.hhplus.clean_architecture.exception;

public class LectureException extends RuntimeException {

    public LectureException(ExceptionInterface exception) {
        super(exception.getMessage());
    }
}
