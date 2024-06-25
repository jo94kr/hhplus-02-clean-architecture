package io.hhplus.clean_architecture.repository;

import io.hhplus.clean_architecture.domain.Lecture;

public interface LectureRepository {

    Lecture findById(Long lectureId);

    Lecture save(Lecture lecture);
}
