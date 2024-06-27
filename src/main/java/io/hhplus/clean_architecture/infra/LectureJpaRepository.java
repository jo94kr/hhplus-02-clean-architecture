package io.hhplus.clean_architecture.infra;

import io.hhplus.clean_architecture.infra.entity.LectureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LectureJpaRepository extends JpaRepository<LectureEntity, Long> {

    Optional<LectureEntity> findLectureById(Long lectureId);
}
