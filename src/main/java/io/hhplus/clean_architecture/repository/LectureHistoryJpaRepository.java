package io.hhplus.clean_architecture.repository;

import io.hhplus.clean_architecture.domain.LectureHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureHistoryJpaRepository extends JpaRepository<LectureHistory, Long> {

}
