package io.hhplus.clean_architecture.domain.repository;

import io.hhplus.clean_architecture.domain.entity.Lecture;

import java.util.List;

public interface LectureRepository {

    /**
     * 특강 조회
     */
    Lecture findById(Long lectureId);

    /**
     * 특강 목록 조회
     */
    List<Lecture> findAllLectureList();

}
