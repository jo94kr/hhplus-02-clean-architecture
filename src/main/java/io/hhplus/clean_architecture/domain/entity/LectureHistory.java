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
    @JoinColumn(name = "lecture_id")
    @Comment("특강 PK")
    private Lecture lecture;

    @Column
    @Comment("사용자 PK")
    private Long userId;

    public LectureHistory(Lecture lecture, Long userId) {
        this.lecture = lecture;
        this.userId = userId;
    }

    public static LectureHistory create(Lecture lecture, Long userId) {
        return new LectureHistory(lecture, userId);
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
