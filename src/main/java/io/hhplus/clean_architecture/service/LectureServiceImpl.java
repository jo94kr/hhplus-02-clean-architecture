package io.hhplus.clean_architecture.service;

import io.hhplus.clean_architecture.domain.Lecture;
import io.hhplus.clean_architecture.domain.LectureHistory;
import io.hhplus.clean_architecture.repository.LectureHistoryRepository;
import io.hhplus.clean_architecture.repository.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true, rollbackFor = {Exception.class})
public class LectureServiceImpl implements LectureService {

    private final LectureRepository lectureRepository;
    private final LectureHistoryRepository lectureHistoryRepository;

    @Override
    public Lecture apply(Long lectureId, Long userId) {
        // 특강 조회
        Lecture lecture = lectureRepository.findById(lectureId);

        // 특강 신청 내역 등록
        LectureHistory lectureHistory = lectureHistoryRepository.save(new LectureHistory(userId));

        return lecture;
    }
}
