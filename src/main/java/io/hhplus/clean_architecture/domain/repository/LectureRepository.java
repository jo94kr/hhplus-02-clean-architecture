package io.hhplus.clean_architecture.domain.repository;

import io.hhplus.clean_architecture.domain.entity.Lecture;

import java.util.List;

public interface LectureRepository {

    Lecture lockedFindById(Long lectureId);

    List<Lecture> findAllLectureList();
}
