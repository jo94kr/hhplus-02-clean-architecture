package io.hhplus.clean_architecture.domain.entity;

import io.hhplus.clean_architecture.common.exception.BaseException;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

import static io.hhplus.clean_architecture.domain.LectureExceptionEnums.Exception.BEFORE_START_DATE;
import static io.hhplus.clean_architecture.domain.LectureExceptionEnums.Exception.MAX_CAPACITY;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "lecture")
public class Lecture extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String lectureName;

    @Column(nullable = false)
    private LocalDateTime lectureDatetime;

    @Column(nullable = false)
    private int registerCnt = 0;

    @Column(nullable = false)
    private int capacity = 30;

    public Lecture(String lectureName,
                   LocalDateTime lectureDatetime,
                   int registerCnt,
                   int capacity) {
        this.lectureName = lectureName;
        this.lectureDatetime = lectureDatetime;
        this.registerCnt = registerCnt;
        this.capacity = capacity;
    }

    /**
     * 특강 신청
     *
     * @throws BaseException 특강 시작일 보다 먼저 신청 BEFORE_START_DATE
     * @throws BaseException 정원 초과 시 MAX_CAPACITY
     */
    public void apply() {
        // 특강 시작일 체크
        if (!LocalDateTime.now().isAfter(this.lectureDatetime)) {
            throw new BaseException(BEFORE_START_DATE);
        }
        // 특강 정원 체크
        if (this.capacity <= this.registerCnt) {
            throw new BaseException(MAX_CAPACITY);
        }

        this.registerCnt = this.registerCnt + 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lecture lecture = (Lecture) o;
        return Objects.equals(id, lecture.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
