package io.hhplus.clean_architecture.domain.exception;

import io.hhplus.clean_architecture.common.exception.BaseException;

public class AlreadyExistException extends BaseException {
    public AlreadyExistException() {
        super(LectureExceptionEnums.Exception.ALREADY_EXISTS);
    }
}
