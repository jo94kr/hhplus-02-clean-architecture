package io.hhplus.clean_architecture.service;

import io.hhplus.clean_architecture.domain.Lecture;

import java.util.List;

public interface LectureService {

    Lecture apply(Long userId, Long id);

    List<Lecture> findAllLectureList();
}
