package io.hhplus.clean_architecture.domain.repository;

import io.hhplus.clean_architecture.domain.entity.Lecture;
import io.hhplus.clean_architecture.domain.entity.LectureHistory;
import io.hhplus.clean_architecture.domain.entity.LectureSchedule;

import java.util.Optional;

public interface LectureHistoryRepository {

    LectureHistory save(LectureHistory lectureHistory);

    Optional<LectureHistory> findLectureHistoryByLectureScheduleAndUserId(LectureSchedule lectureSchedule, Long userId);
}
