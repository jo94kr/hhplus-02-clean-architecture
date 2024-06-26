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
    public List<Lecture> findAllLectureList() {
        return lectureJpaRepository.findAll();
    }

    @Override
    public Lecture findById(Long lectureId) {
        return lectureJpaRepository.findById(lectureId)
                .orElseThrow(EntityNotFoundException::new);
    }
}
