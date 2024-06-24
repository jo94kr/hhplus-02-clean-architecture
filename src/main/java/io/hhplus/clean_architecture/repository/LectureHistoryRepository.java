package io.hhplus.clean_architecture.repository;

import io.hhplus.clean_architecture.domain.LectureHistory;

public interface LectureHistoryRepository {

    LectureHistory save(LectureHistory lectureHistory);
}
