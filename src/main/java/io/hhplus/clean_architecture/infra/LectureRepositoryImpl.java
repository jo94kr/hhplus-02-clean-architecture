package io.hhplus.clean_architecture.infra;

import io.hhplus.clean_architecture.domain.entity.Lecture;
import io.hhplus.clean_architecture.domain.repository.LectureRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class LectureRepositoryImpl implements LectureRepository {

    private final LectureJpaRepository lectureJpaRepository;

    @Override
    public Lecture lockedFindById(Long lectureId) {
        return lectureJpaRepository.findLectureById(lectureId)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Lecture> findAllLectureList() {
        return lectureJpaRepository.findAll();
    }
}
