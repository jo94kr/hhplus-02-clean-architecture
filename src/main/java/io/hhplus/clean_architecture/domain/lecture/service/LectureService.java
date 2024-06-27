package io.hhplus.clean_architecture.domain.lecture.service;

import io.hhplus.clean_architecture.domain.lecture.Lecture;
import io.hhplus.clean_architecture.domain.lecture.LectureSchedule;

import java.util.List;

public interface LectureService {

    /**
     * 특강 신청
     */
    LectureSchedule apply(Long userId, Long lectureId);

    /**
     * 특강 신청 여부 확인
     */
    Boolean lectureApplicationCheck(Long userId, Long lectureId);

    /**
     * 특강 스케쥴 목록 조회
     */
    List<LectureSchedule> findAllLectureScheduleList(Long lectureId);

    /**
     * 특강 목록 조회
     */
    List<Lecture> findAllLectureList();
}
