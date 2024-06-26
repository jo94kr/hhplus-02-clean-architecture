package io.hhplus.clean_architecture.controller.dto;

import io.hhplus.clean_architecture.domain.entity.Lecture;

import java.time.LocalDateTime;

public record LectureResDto(
        Long lectureId,
        String lectureName,
        LocalDateTime lectureDatetime,
        int capacity,
        int registerCnt
) {

    public static LectureResDto of(Lecture lecture) {
        return new LectureResDto(lecture.getId(),
                lecture.getLectureName(),
                lecture.getLectureDatetime(),
                lecture.getCapacity(),
                lecture.getRegisterCnt());
    }
}
