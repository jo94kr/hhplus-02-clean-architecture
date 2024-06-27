package io.hhplus.clean_architecture.domain.lecture;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LectureHistory {

    private Long id;
    private LectureSchedule lectureSchedule;
    private Long userId;

    public static LectureHistory create(LectureSchedule lectureSchedule, Long userId) {
        return LectureHistory.builder()
                .lectureSchedule(lectureSchedule)
                .userId(userId)
                .build();
    }
}
