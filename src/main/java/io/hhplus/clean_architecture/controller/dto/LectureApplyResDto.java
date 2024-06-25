package io.hhplus.clean_architecture.controller.dto;

import io.hhplus.clean_architecture.domain.Lecture;

public record LectureApplyResDto(
        Long lectureId,
        String lectureName,
        int capacity,
        int registerCnt
) {

    public static LectureApplyResDto of(Lecture lecture) {
        return new LectureApplyResDto(lecture.getId(), lecture.getLectureName(), lecture.getCapacity(), lecture.getRegisterCnt());
    }
}
