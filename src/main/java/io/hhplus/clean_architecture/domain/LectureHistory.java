package io.hhplus.clean_architecture.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "lecture_history")
public class LectureHistory extends BaseCreateDatetimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;

    @Column
    private Long userId;

    public LectureHistory(Lecture lecture, Long userId) {
        this.lecture = lecture;
        this.userId = userId;
    }

    public static LectureHistory registerLecture(Lecture lecture, Long userId) {
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
