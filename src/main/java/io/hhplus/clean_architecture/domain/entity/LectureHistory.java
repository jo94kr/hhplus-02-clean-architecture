package io.hhplus.clean_architecture.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.util.Objects;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "lecture_history")
public class LectureHistory extends BaseCreateDatetimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("특강 신청 내역 PK")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecture_schedule_id")
    @Comment("특강 스케쥴 PK")
    private LectureSchedule lectureSchedule;

    @Column
    @Comment("사용자 PK")
    private Long userId;

    public LectureHistory(LectureSchedule lectureSchedule, Long userId) {
        this.lectureSchedule = lectureSchedule;
        this.userId = userId;
    }

    public static LectureHistory create(LectureSchedule lectureSchedule, Long userId) {
        return new LectureHistory(lectureSchedule, userId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LectureHistory that = (LectureHistory) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
