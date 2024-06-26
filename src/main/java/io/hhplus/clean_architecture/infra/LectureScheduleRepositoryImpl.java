package io.hhplus.clean_architecture.infra;

import io.hhplus.clean_architecture.domain.entity.Lecture;
import io.hhplus.clean_architecture.domain.entity.LectureSchedule;
import io.hhplus.clean_architecture.domain.repository.LectureScheduleRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class LectureScheduleRepositoryImpl implements LectureScheduleRepository {

    private final LectureScheduleJpaRepository lectureScheduleJpaRepository;

    @Override
    public LectureSchedule lockedFindById(Long lectureScheduleId) {
        return lectureScheduleJpaRepository.findLectureScheduleById(lectureScheduleId)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public LectureSchedule findById(Long lectureScheduleId) {
        return lectureScheduleJpaRepository.findById(lectureScheduleId)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<LectureSchedule> findAllLectureScheduleList(Lecture lecture) {
        return lectureScheduleJpaRepository.findAllByLecture(lecture);
    }
}
