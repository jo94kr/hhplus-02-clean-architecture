package io.hhplus.clean_architecture.infra;

import io.hhplus.clean_architecture.domain.Lecture;
import io.hhplus.clean_architecture.repository.LectureJpaRepository;
import io.hhplus.clean_architecture.repository.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

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
