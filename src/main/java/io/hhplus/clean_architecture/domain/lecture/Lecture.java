package io.hhplus.clean_architecture.domain.lecture;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Lecture {

    private Long id;
    private String lectureName;
}
