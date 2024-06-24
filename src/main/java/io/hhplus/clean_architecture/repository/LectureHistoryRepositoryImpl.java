package io.hhplus.clean_architecture.repository;

import io.hhplus.clean_architecture.domain.LectureHistory;
import io.hhplus.clean_architecture.infra.LectureHistoryJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class LectureHistoryRepositoryImpl implements LectureHistoryRepository {

    private final LectureHistoryJpaRepository lectureHistoryJpaRepository;

    @Override
    public LectureHistory save(LectureHistory lectureHistory) {
        return lectureHistoryJpaRepository.save(lectureHistory);
    }
}
