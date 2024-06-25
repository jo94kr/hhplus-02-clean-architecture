package io.hhplus.clean_architecture.repository.infra;

import io.hhplus.clean_architecture.domain.Lecture;
import io.hhplus.clean_architecture.domain.LectureHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LectureHistoryJpaRepository extends JpaRepository<LectureHistory, Long> {

    Optional<LectureHistory> findLectureHistoryByLectureAndUserId(Lecture lecture, Long userId);
}
