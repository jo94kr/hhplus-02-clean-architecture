package io.hhplus.clean_architecture.service;

import io.hhplus.clean_architecture.domain.Lecture;
import io.hhplus.clean_architecture.domain.LectureHistory;
import io.hhplus.clean_architecture.common.exception.BaseException;
import io.hhplus.clean_architecture.repository.LectureHistoryRepository;
import io.hhplus.clean_architecture.repository.LectureRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LectureServiceTest {

    @InjectMocks
    private LectureServiceImpl lectureServiceImpl;

    @Mock
    private LectureRepository lectureRepository;

    @Mock
    private LectureHistoryRepository lectureHistoryRepository;

    private Lecture defaultLecture;

    @BeforeEach
    void setUp() {
        // 특강 기본 세팅
        defaultLecture = new Lecture("항해 플러스 백엔드",
                LocalDateTime.of(2024, 6, 25, 12, 0, 0),
                0,
                30);
    }

    @Test
    @DisplayName("아이디로 특강 신청 성공")
    void apply() {
        // given
        Long lectureId = 1L;
        Long userId = 1L;

        // when
        when(lectureRepository.findById(lectureId)).thenReturn(defaultLecture);
        Lecture result = lectureServiceImpl.apply(userId, userId);

        // then
        verify(lectureHistoryRepository).save(any());
        assertThat(result.getRegisterCnt()).isEqualTo(1);
    }

    @Test
    @DisplayName("특강 중복 신청 불가 예외 발생")
    void applyDuplicateLecture() {
        // given
        Long lectureId = 1L;
        Long userId = 1L;

        // when
        when(lectureRepository.findById(lectureId)).thenReturn(defaultLecture);
        when(lectureHistoryRepository.findLectureHistoryByLectureAndUserId(defaultLecture, userId))
                .thenReturn(Optional.of(new LectureHistory(defaultLecture, userId)));

        // then
        assertThrows(BaseException.class, () -> lectureServiceImpl.apply(userId, userId));
    }

    @Test
    @DisplayName("특강 정원 30명 초과 예외 발생")
    void lectureCapacity() {
        // given
        Long lectureId = 1L;
        Long userId = 1L;
        Lecture lecture = new Lecture("항해 플러스 백엔드", LocalDateTime.now(), 30, 30);

        // when
        when(lectureRepository.findById(lectureId)).thenReturn(lecture);
        when(lectureHistoryRepository.findLectureHistoryByLectureAndUserId(lecture, userId))
                .thenReturn(Optional.empty());

        // then
        assertThrows(BaseException.class, () -> lectureServiceImpl.apply(userId, userId));
    }

    @Test
    @DisplayName("특강 시작일 이전에 특강 신청 시도 시 예외 발생")
    void applyLectureBeforeStartDate() {
        // given
        Long lectureId = 1L;
        Long userId = 1L;
        Lecture lecture = new Lecture("항해 플러스 백엔드", LocalDateTime.now().plusDays(1), 30, 30);

        // when
        when(lectureRepository.findById(lectureId)).thenReturn(lecture);
        when(lectureHistoryRepository.findLectureHistoryByLectureAndUserId(lecture, userId))
                .thenReturn(Optional.empty());

        // then
        assertThrows(BaseException.class, () -> lectureServiceImpl.apply(lectureId, userId));
    }
}
