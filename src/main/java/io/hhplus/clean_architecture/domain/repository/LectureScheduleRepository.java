package io.hhplus.clean_architecture.domain.repository;

import io.hhplus.clean_architecture.domain.entity.Lecture;
import io.hhplus.clean_architecture.domain.entity.LectureSchedule;

import java.util.List;

public interface LectureScheduleRepository {

    /**
     * 특강 스케쥴 조회 - lock
     */
    LectureSchedule lockedFindById(Long lectureScheduleId);

    LectureSchedule findById(Long lectureScheduleId);

    List<LectureSchedule> findAllLectureScheduleList(Lecture lecture);
}
