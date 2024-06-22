package io.hhplus.clean_architecture.domain.lecture.repository;

import io.hhplus.clean_architecture.domain.lecture.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureJpaRepository extends JpaRepository<Lecture, Long> {


}
