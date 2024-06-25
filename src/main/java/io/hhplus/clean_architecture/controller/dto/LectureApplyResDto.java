package io.hhplus.clean_architecture.controller.dto;

public record LectureApplyResDto(
        Boolean result
) {

    public static LectureApplyResDto of(Boolean result) {
        return new LectureApplyResDto(result);
    }
}
