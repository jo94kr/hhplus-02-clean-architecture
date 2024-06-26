package io.hhplus.clean_architecture.infra;

import io.hhplus.clean_architecture.domain.entity.Lecture;
import io.hhplus.clean_architecture.domain.entity.LectureSchedule;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.List;
import java.util.Optional;

public interface LectureScheduleJpaRepository extends JpaRepository<LectureSchedule, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<LectureSchedule> findLectureScheduleById(Long lectureScheduleId);

    List<LectureSchedule> findAllByLecture(Lecture lecture);
}
