package io.hhplus.clean_architecture.domain.lecture;

import io.hhplus.clean_architecture.common.exception.BaseException;
import io.hhplus.clean_architecture.domain.lecture.exception.AlreadyExistException;
import io.hhplus.clean_architecture.domain.lecture.exception.LectureCapacityException;
import io.hhplus.clean_architecture.domain.lecture.exception.LectureDateException;
import io.hhplus.clean_architecture.domain.lecture.repository.LectureHistoryRepository;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class LectureSchedule {

    private Long id;
    private Lecture lecture;
    private LocalDateTime lectureDatetime;
    private int registerCnt;
    private int capacity;

    /**
     * 특강 신청
     *
     * @throws LectureDateException 특강 시작일 보다 먼저 신청 BEFORE_START_DATE
     * @throws LectureCapacityException 정원 초과 시 MAX_CAPACITY
     */
    public LectureSchedule apply() {
        // 특강 시작일 체크
        if (!LocalDateTime.now().isAfter(this.lectureDatetime)) {
            throw new LectureDateException();
        }
        // 특강 정원 체크
        if (this.capacity <= this.registerCnt) {
            throw new LectureCapacityException();
        }

        this.registerCnt += 1;

        return this;
    }
}
