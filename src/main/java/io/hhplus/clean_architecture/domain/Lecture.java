package io.hhplus.clean_architecture.domain;

import io.hhplus.clean_architecture.exception.LectureException;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

import static io.hhplus.clean_architecture.exception.LectureExceptionEnums.Exception.BEFORE_START_DATE;
import static io.hhplus.clean_architecture.exception.LectureExceptionEnums.Exception.MAX_CAPACITY;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "lecture")
public class Lecture extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String lectureName;

    @Column
    private LocalDateTime lectureDatetime;

    @Column
    private int registerCnt;

    @Column
    private int capacity;

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
     * @throws LectureException 특강 시작일 보다 먼저 신청 BEFORE_START_DATE
     * @throws LectureException 정원 초과 시 MAX_CAPACITY
     */
    public Lecture registLecture() {
        // 특강 시작일 체크
        if (!LocalDateTime.now().isAfter(this.lectureDatetime)) {
            throw new LectureException(BEFORE_START_DATE);
        }
        // 특강 정원 체크
        if (this.capacity >= this.registerCnt) {
            throw new LectureException(MAX_CAPACITY);
        }

        this.registerCnt = this.registerCnt + 1;
        return this;
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
