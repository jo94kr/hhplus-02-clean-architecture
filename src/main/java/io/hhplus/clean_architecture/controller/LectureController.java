package io.hhplus.clean_architecture.controller;

import io.hhplus.clean_architecture.controller.dto.LectureResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lectures")
public class LectureController {

    private final LectureService lectureService;

    @PostMapping("/{lectureId}/apply")
    public ResponseEntity<Void> apply(@PathVariable(name = "lectureId") Long lectureId, @RequestBody Long userId) {
        lectureService.apply(lectureId, userId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<LectureResDto>> findAllLectureList() {
        return ResponseEntity.ok().body(lectureService.findAllLectureList().stream()
                .map(LectureResDto::of)
                .toList());
    }

    @GetMapping("/application/{userId}")
    public ResponseEntity<Boolean> lectureApplicationCheck(@PathVariable(name = "userId") Long userId, @RequestParam(name = "lectureId") Long lectureId) {
        return ResponseEntity.ok().body(lectureService.lectureApplicationCheck(userId, lectureId));
    }
}
