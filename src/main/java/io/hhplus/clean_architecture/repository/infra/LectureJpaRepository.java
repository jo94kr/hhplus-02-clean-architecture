package io.hhplus.clean_architecture.repository.infra;

import io.hhplus.clean_architecture.domain.Lecture;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.Optional;

public interface LectureJpaRepository extends JpaRepository<Lecture, Long> {

    @Override
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Lecture> findById(Long lectureId);
}
