package io.hhplus.clean_architecture.infra;

import io.hhplus.clean_architecture.domain.entity.Lecture;
import io.hhplus.clean_architecture.domain.entity.LectureHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LectureHistoryJpaRepository extends JpaRepository<LectureHistory, Long> {

    Optional<LectureHistory> findLectureHistoryByLectureAndUserId(Lecture lecture, Long userId);
}
