package io.hhplus.clean_architecture.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

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
