package io.hhplus.clean_architecture.repository;

import io.hhplus.clean_architecture.domain.Lecture;
import io.hhplus.clean_architecture.repository.infra.LectureJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;

@Repository
@RequiredArgsConstructor
public class LectureRepositoryImpl implements LectureRepository {

    private final LectureJpaRepository lectureJpaRepository;

    @Override
    public Lecture findById(Long lectureId) {
        return lectureJpaRepository.findById(lectureId)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Lecture save(Lecture lecture) {
        return lectureJpaRepository.save(lecture);
    }

    @Override
    public List<Lecture> findAllLectureList() {
        return lectureJpaRepository.findAll();
    }
}
