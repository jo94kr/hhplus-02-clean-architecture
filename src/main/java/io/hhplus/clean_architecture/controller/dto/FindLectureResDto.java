package io.hhplus.clean_architecture.controller.dto;

import io.hhplus.clean_architecture.domain.lecture.Lecture;

public record FindLectureResDto(
        Long lectureId,
        String lectureName
) {

    public static FindLectureResDto of(Lecture lecture) {
        return new FindLectureResDto(lecture.getId(), lecture.getLectureName());
    }
}
