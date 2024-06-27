package io.hhplus.clean_architecture.domain.lecture;

import io.hhplus.clean_architecture.domain.lecture.exception.LectureCapacityException;
import io.hhplus.clean_architecture.domain.lecture.exception.LectureDateException;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;

class LectureScheduleTest {

    @Test
    @DisplayName("특강 신청 정상 처리")
    void apply() {
        // given
        Lecture lecture = Lecture.builder().lectureName("항해 플러스 백엔드").build();
        LectureSchedule lectureSchedule = LectureSchedule.builder()
                .lecture(lecture)
                .lectureDatetime(LocalDateTime.of(2024, 6, 25, 13, 0, 0))
                .registerCnt(0)
                .capacity(30)
                .build();

        // when
        LectureSchedule apply = lectureSchedule.apply();

        // then
        assertThat(apply.getRegisterCnt()).isEqualTo(1);
    }

    @Test
    @DisplayName("시작일 이전 특강 신청")
    void applyLectureBeforeStartDate() {
        // given
        Lecture lecture = Lecture.builder().lectureName("항해 플러스 백엔드").build();
        LectureSchedule lectureSchedule = LectureSchedule.builder()
                .lecture(lecture)
                .lectureDatetime(LocalDateTime.now().plusDays(1))
                .registerCnt(0)
                .capacity(30)
                .build();

        // when
        ThrowableAssert.ThrowingCallable throwingCallable = lectureSchedule::apply;

        // then
        assertThatExceptionOfType(LectureDateException.class).isThrownBy(throwingCallable);
    }
    
    @Test
    @DisplayName("정원 초과 상태에서 특강 신청")
    void lectureCapacityOver() {
        // given
        Lecture lecture = Lecture.builder().lectureName("항해 플러스 백엔드").build();
        LectureSchedule lectureSchedule = LectureSchedule.builder()
                .lecture(lecture)
                .lectureDatetime(LocalDateTime.of(2024, 6, 25, 13, 0, 0))
                .registerCnt(30)
                .capacity(30)
                .build();

        // when
        ThrowableAssert.ThrowingCallable throwingCallable = lectureSchedule::apply;
        
        // then
        assertThatExceptionOfType(LectureCapacityException.class).isThrownBy(throwingCallable);
    }
}
