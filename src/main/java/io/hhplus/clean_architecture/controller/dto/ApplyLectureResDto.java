package io.hhplus.clean_architecture.controller.dto;

import io.hhplus.clean_architecture.domain.lecture.Lecture;
import io.hhplus.clean_architecture.domain.lecture.LectureSchedule;

public record ApplyLectureResDto(
        Long lectureId,
        Long lectureScheduleId,
        String name
) {

    public static ApplyLectureResDto of(LectureSchedule lectureSchedule) {
        Lecture lectureEntity = lectureSchedule.getLecture();
        return new ApplyLectureResDto(lectureEntity.getId(), lectureSchedule.getId(), lectureEntity.getLectureName());
    }
}
