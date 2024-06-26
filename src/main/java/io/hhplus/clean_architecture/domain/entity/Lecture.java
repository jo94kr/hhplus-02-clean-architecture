package io.hhplus.clean_architecture.domain.entity;

import io.hhplus.clean_architecture.common.exception.BaseException;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

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
    @Comment("특강 PK")
    private Long id;

    @Column(nullable = false)
    @Comment("특강 명")
    private String lectureName;

    public Lecture(String lectureName) {
        this.lectureName = lectureName;
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
