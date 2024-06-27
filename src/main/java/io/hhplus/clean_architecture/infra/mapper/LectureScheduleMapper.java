package io.hhplus.clean_architecture.infra.mapper;

import io.hhplus.clean_architecture.domain.lecture.Lecture;
import io.hhplus.clean_architecture.domain.lecture.LectureSchedule;
import io.hhplus.clean_architecture.infra.entity.LectureEntity;
import io.hhplus.clean_architecture.infra.entity.LectureScheduleEntity;

public class LectureScheduleMapper {
    public static LectureSchedule toDomain(LectureScheduleEntity lectureScheduleEntity) {
        return LectureSchedule.builder()
                .id(lectureScheduleEntity.getId())
                .lecture(LectureMapper.toDomain(lectureScheduleEntity.getLecture()))
                .lectureDatetime(lectureScheduleEntity.getLectureDatetime())
                .registerCnt(lectureScheduleEntity.getRegisterCnt())
                .capacity(lectureScheduleEntity.getCapacity())
                .build();
    }

    public static LectureScheduleEntity toEntity(LectureSchedule lectureSchedule) {
        return new LectureScheduleEntity(lectureSchedule.getId(),
                LectureMapper.toEntity(lectureSchedule.getLecture()),
                lectureSchedule.getLectureDatetime(),
                lectureSchedule.getRegisterCnt(),
                lectureSchedule.getCapacity());
    }
}
