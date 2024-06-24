package io.hhplus.clean_architecture.service;

import io.hhplus.clean_architecture.domain.Lecture;
import io.hhplus.clean_architecture.domain.LectureHistory;
import io.hhplus.clean_architecture.repository.LectureHistoryJpaRepository;
import io.hhplus.clean_architecture.repository.LectureHistoryRepository;
import io.hhplus.clean_architecture.repository.LectureJpaRepository;
import io.hhplus.clean_architecture.repository.LectureRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LectureServiceTest {

    @InjectMocks
    private LectureServiceImpl lectureServiceImpl;

    @Mock
    private LectureRepository lectureRepository;

    @Mock
    private LectureHistoryRepository lectureHistoryRepository;

    @Test
    @DisplayName("아이디로 특강 신청 성공")
    void apply() {
        // given
        Long lectureId = 1L;
        Long userId = 1L;
        Lecture lecture = new Lecture(userId);

        // when
        when(lectureRepository.findById(lectureId)).thenReturn(new Lecture(lectureId));
        when(lectureHistoryRepository.save(new LectureHistory(lectureId))).thenReturn(any());
        Lecture result = lectureServiceImpl.apply(userId, userId);

        // then
        assertThat(result).isEqualTo(lecture);
    }
}
