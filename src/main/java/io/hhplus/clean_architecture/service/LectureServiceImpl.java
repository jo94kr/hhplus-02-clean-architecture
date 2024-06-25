package io.hhplus.clean_architecture.service;

import io.hhplus.clean_architecture.domain.Lecture;
import io.hhplus.clean_architecture.domain.LectureHistory;
import io.hhplus.clean_architecture.exception.LectureException;
import io.hhplus.clean_architecture.exception.LectureExceptionEnums;
import io.hhplus.clean_architecture.repository.LectureHistoryRepository;
import io.hhplus.clean_architecture.repository.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true, rollbackFor = {Exception.class})
public class LectureServiceImpl implements LectureService {

    private final LectureRepository lectureRepository;
    private final LectureHistoryRepository lectureHistoryRepository;

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Boolean apply(Long lectureId, Long userId) {
        // 특강 조회
        Lecture lecture = lectureRepository.findById(lectureId);

        // 사용자 특강 조회
        Optional<LectureHistory> optionalUserLectureHistory = lectureHistoryRepository.findLectureHistoryByLectureAndUserId(lecture, userId);
        if (optionalUserLectureHistory.isPresent()) {
            throw new LectureException(LectureExceptionEnums.Exception.ALREADY_EXISTS);
        }

        // 특강 신청
        LectureHistory registerLectureHistory = LectureHistory.registerLecture(lecture.registLecture(), userId);
        lectureHistoryRepository.save(registerLectureHistory);

        return Boolean.TRUE;
    }
}
