package io.hhplus.clean_architecture.repository;

import io.hhplus.clean_architecture.domain.Lecture;
import io.hhplus.clean_architecture.infra.LectureJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.NoSuchElementException;

@Repository
@RequiredArgsConstructor
public class LectureRepositoryImpl implements LectureRepository {

    private final LectureJpaRepository lectureJpaRepository;

    @Override
    public Lecture findById(Long lectureId) {
        return lectureJpaRepository.findById(lectureId).orElseThrow(NoSuchElementException::new);
    }
}
