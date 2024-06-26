package io.hhplus.clean_architecture.controller;

import io.hhplus.clean_architecture.domain.entity.Lecture;

import java.util.List;

public interface LectureService {

    void apply(Long userId, Long lectureId);

    List<Lecture> findAllLectureList();

    Boolean lectureApplicationCheck(Long userId, Long lectureId);
}
