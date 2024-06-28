package io.hhplus.clean_architecture.infra;

import io.hhplus.clean_architecture.domain.lecture.Lecture;
import io.hhplus.clean_architecture.domain.lecture.repository.LectureRepository;
import io.hhplus.clean_architecture.infra.mapper.LectureMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class LectureRepositoryImpl implements LectureRepository {

    private final LectureJpaRepository lectureJpaRepository;

    @Override
    public List<Lecture> findAllLectureList() {
        return lectureJpaRepository.findAll().stream()
                .map(LectureMapper::toDomain)
                .toList();
    }

    @Override
    public Lecture findById(Long lectureId) {
        return LectureMapper.toDomain(lectureJpaRepository.findById(lectureId)
                .orElseThrow(EntityNotFoundException::new));
    }
}
