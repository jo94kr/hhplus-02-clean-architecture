package io.hhplus.clean_architecture.infra;

import io.hhplus.clean_architecture.domain.entity.Lecture;
import io.hhplus.clean_architecture.domain.entity.LectureHistory;
import io.hhplus.clean_architecture.domain.repository.LectureHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class LectureHistoryRepositoryImpl implements LectureHistoryRepository {

    private final LectureHistoryJpaRepository lectureHistoryJpaRepository;

    @Override
    public LectureHistory save(LectureHistory lectureHistory) {
        return lectureHistoryJpaRepository.save(lectureHistory);
    }

    @Override
    public Optional<LectureHistory> findLectureHistoryByLectureAndUserId(Lecture lecture, Long userId) {
        return lectureHistoryJpaRepository.findLectureHistoryByLectureAndUserId(lecture, userId);
    }
}
