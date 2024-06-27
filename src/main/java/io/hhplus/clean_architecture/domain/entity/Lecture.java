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
