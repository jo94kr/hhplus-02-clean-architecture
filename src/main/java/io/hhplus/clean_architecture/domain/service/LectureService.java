package io.hhplus.clean_architecture.domain.service;

import io.hhplus.clean_architecture.domain.entity.Lecture;

import java.util.List;

public interface LectureService {

    void apply(Long userId, Long id);

    List<Lecture> findAllLectureList();
}
