package io.hhplus.clean_architecture.controller.dto;

import io.hhplus.clean_architecture.domain.entity.Lecture;
import io.hhplus.clean_architecture.domain.entity.LectureSchedule;

public record ApplyLectureResDto(
        Long lectureId,
        Long lectureScheduleId,
        String name
) {

    public static ApplyLectureResDto of(LectureSchedule lectureSchedule) {
        Lecture lecture = lectureSchedule.getLecture();
        return new ApplyLectureResDto(lecture.getId(), lectureSchedule.getId(), lecture.getLectureName());
    }
}
