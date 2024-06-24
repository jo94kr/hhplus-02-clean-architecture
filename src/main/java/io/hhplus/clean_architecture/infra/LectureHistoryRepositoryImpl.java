package io.hhplus.clean_architecture.infra;

import io.hhplus.clean_architecture.domain.LectureHistory;
import io.hhplus.clean_architecture.repository.LectureHistoryJpaRepository;
import io.hhplus.clean_architecture.repository.LectureHistoryRepository;
import io.hhplus.clean_architecture.repository.LectureJpaRepository;
import io.hhplus.clean_architecture.repository.LectureRepository;
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
