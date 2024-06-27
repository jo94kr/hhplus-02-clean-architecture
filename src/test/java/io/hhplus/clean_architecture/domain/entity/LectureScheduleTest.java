package io.hhplus.clean_architecture.domain.entity;

import io.hhplus.clean_architecture.domain.exception.LectureCapacityException;
import io.hhplus.clean_architecture.domain.exception.LectureDateException;
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
        Lecture lecture = new Lecture("항해 플러스 백엔드");
        LectureSchedule lectureSchedule = new LectureSchedule(lecture,
                LocalDateTime.of(2024, 6, 25, 13, 0, 0),
                0,
                30);

        // when
        LectureSchedule apply = lectureSchedule.apply();

        // then
        assertThat(apply.getRegisterCnt()).isEqualTo(1);
    }

    @Test
    @DisplayName("시작일 이전 특강 신청")
    void applyLectureBeforeStartDate() {
        // given
        Lecture lecture = new Lecture("항해 플러스 백엔드");
        LectureSchedule lectureSchedule = new LectureSchedule(lecture,
                LocalDateTime.now().plusDays(1),
                0,
                30);

        // when
        ThrowableAssert.ThrowingCallable throwingCallable = lectureSchedule::apply;

        // then
        assertThatExceptionOfType(LectureDateException.class).isThrownBy(throwingCallable);
    }
    
    @Test
    @DisplayName("정원 초과 상태에서 특강 신청")
    void lectureCapacityOver() {
        // given
        Lecture lecture = new Lecture("항해 플러스 백엔드");
        LectureSchedule lectureSchedule = new LectureSchedule(lecture,
                LocalDateTime.of(2024, 6, 25, 13, 0, 0),
                30,
                30);
        
        // when
        ThrowableAssert.ThrowingCallable throwingCallable = lectureSchedule::apply;
        
        // then
        assertThatExceptionOfType(LectureCapacityException.class).isThrownBy(throwingCallable);
    }
}
