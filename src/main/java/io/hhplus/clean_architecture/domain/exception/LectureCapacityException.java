package io.hhplus.clean_architecture.domain.exception;

import io.hhplus.clean_architecture.common.exception.BaseException;

public class LectureCapacityException extends BaseException {
    public LectureCapacityException() {
        super(LectureExceptionEnums.Exception.MAX_CAPACITY);
    }
}
