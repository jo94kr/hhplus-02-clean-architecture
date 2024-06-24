package io.hhplus.clean_architecture.repository;

import io.hhplus.clean_architecture.domain.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureJpaRepository extends JpaRepository<Lecture, Long> {


}
