package io.hhplus.clean_architecture.infra.entity;

import io.hhplus.clean_architecture.common.exception.BaseException;
import io.hhplus.clean_architecture.domain.lecture.exception.LectureCapacityException;
import io.hhplus.clean_architecture.domain.lecture.exception.LectureDateException;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "lecture_schedule")
public class LectureScheduleEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("특강 스케쥴 PK")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecture_id")
    @Comment("특강 PK")
    private LectureEntity lecture;

    @Column(nullable = false)
    @Comment("특강 시작일시")
    private LocalDateTime lectureDatetime;

    @Column(nullable = false)
    @Comment("신청 인원")
    private int registerCnt = 0;

    @Column(nullable = false)
    @Comment("정원")
    private int capacity = 30;

    public LectureScheduleEntity(Long id,
                                 LectureEntity lectureEntity,
                                 LocalDateTime lectureDatetime,
                                 int registerCnt,
                                 int capacity) {
        this.id = id;
        this.lecture = lectureEntity;
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
    public LectureScheduleEntity apply() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LectureScheduleEntity lectureScheduleEntity = (LectureScheduleEntity) o;
        return Objects.equals(id, lectureScheduleEntity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
