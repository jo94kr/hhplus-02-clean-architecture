package io.hhplus.clean_architecture.domain.lecture.repository;

import io.hhplus.clean_architecture.domain.lecture.Lecture;
import io.hhplus.clean_architecture.infra.entity.LectureEntity;

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
