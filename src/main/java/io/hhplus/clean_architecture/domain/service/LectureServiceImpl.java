package io.hhplus.clean_architecture.domain.service;

import io.hhplus.clean_architecture.domain.entity.Lecture;
import io.hhplus.clean_architecture.domain.LectureExceptionEnums;
import io.hhplus.clean_architecture.domain.entity.LectureHistory;
import io.hhplus.clean_architecture.common.exception.BaseException;
import io.hhplus.clean_architecture.domain.repository.LectureHistoryRepository;
import io.hhplus.clean_architecture.domain.repository.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true, rollbackFor = {Exception.class})
public class LectureServiceImpl implements LectureService {

    private final LectureRepository lectureRepository;
    private final LectureHistoryRepository lectureHistoryRepository;

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void apply(Long lectureId, Long userId) {
        // 특강 조회
        Lecture lecture = lectureRepository.findById(lectureId);

        // 사용자 특강 조회
        Optional<LectureHistory> optionalUserLectureHistory = lectureHistoryRepository.findLectureHistoryByLectureAndUserId(lecture, userId);
        if (optionalUserLectureHistory.isPresent()) {
            throw new BaseException(LectureExceptionEnums.Exception.ALREADY_EXISTS);
        }

        // 특강 신청
        lecture.apply();
        
        // 특강 내역 등록
        lectureHistoryRepository.save(LectureHistory.create(lecture, userId));
    }

    @Override
    public List<Lecture> findAllLectureList() {
        return lectureRepository.findAllLectureList();
    }
}
