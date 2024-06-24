package io.hhplus.clean_architecture.service;

import io.hhplus.clean_architecture.domain.Lecture;

public interface LectureService {

    Lecture apply(Long userId, Long id);
}
