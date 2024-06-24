package io.hhplus.clean_architecture.controller.dto;

import io.hhplus.clean_architecture.domain.Lecture;

public record LectureApplyResDto(
        Long id
) {

    public static LectureApplyResDto of(Lecture lecture) {
        return new LectureApplyResDto(lecture.getId());
    }
}
