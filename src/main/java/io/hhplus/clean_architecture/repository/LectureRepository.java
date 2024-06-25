package io.hhplus.clean_architecture.repository;

import io.hhplus.clean_architecture.domain.Lecture;

import java.util.List;

public interface LectureRepository {

    Lecture findById(Long lectureId);

    Lecture save(Lecture lecture);

    List<Lecture> findAllLectureList();
}
