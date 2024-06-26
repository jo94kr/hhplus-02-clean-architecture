package io.hhplus.clean_architecture.controller;

import io.hhplus.clean_architecture.domain.entity.Lecture;
import io.hhplus.clean_architecture.domain.entity.LectureSchedule;

import java.util.List;
import java.util.Optional;

public interface LectureService {

    LectureSchedule apply(Long userId, Long lectureId);

    Boolean lectureApplicationCheck(Long userId, Long lectureId);

    List<LectureSchedule> findAllLectureScheduleList(Long lectureId);

    List<Lecture> findAllLectureList();
}
