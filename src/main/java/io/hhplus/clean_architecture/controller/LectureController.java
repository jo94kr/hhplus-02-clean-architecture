package io.hhplus.clean_architecture.controller;

import io.hhplus.clean_architecture.controller.dto.ApplyLectureResDto;
import io.hhplus.clean_architecture.controller.dto.FindLectureResDto;
import io.hhplus.clean_architecture.controller.dto.FindLectureScheduleResDto;
import io.hhplus.clean_architecture.domain.entity.LectureSchedule;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lectures")
public class LectureController {

    private final LectureService lectureService;

    /**
     * 특강 신청
     */
    @PostMapping("/{lectureScheduleId}/apply")
    public ResponseEntity<ApplyLectureResDto> apply(@PathVariable(name = "lectureScheduleId") Long lectureScheduleId, @RequestBody Long userId) {
        LectureSchedule result = lectureService.apply(lectureScheduleId, userId);
        return ResponseEntity.ok(ApplyLectureResDto.of(result));
    }

    /**
     * 특강 목록
     */
    @GetMapping
    public ResponseEntity<List<FindLectureResDto>> findAllLectureList() {
        return ResponseEntity.ok(lectureService.findAllLectureList().stream()
                .map(FindLectureResDto::of)
                .toList());
    }

    /**
     * 특강 스케쥴 목록
     */
    @GetMapping("/{lectureId}/schedule")
    public ResponseEntity<List<FindLectureScheduleResDto>> findAllLectureScheduleList(@PathVariable(name = "lectureId") Long lectureId) {
        return ResponseEntity.ok(lectureService.findAllLectureScheduleList(lectureId).stream()
                .map(FindLectureScheduleResDto::of)
                .toList());
    }

    /**
     * 특강 신청 여부 조회
     */
    @GetMapping("/application/{userId}")
    public ResponseEntity<Boolean> lectureApplicationCheck(@PathVariable(name = "userId") Long userId,
                                                           @RequestParam(name = "lectureScheduleId") Long lectureScheduleId) {
        return ResponseEntity.ok(lectureService.lectureApplicationCheck(userId, lectureScheduleId));
    }
}
