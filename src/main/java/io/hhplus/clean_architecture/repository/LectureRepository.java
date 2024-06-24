package io.hhplus.clean_architecture.repository;

import io.hhplus.clean_architecture.domain.Lecture;

import java.util.Optional;

public interface LectureRepository {

    Lecture findById(Long lectureId);
}