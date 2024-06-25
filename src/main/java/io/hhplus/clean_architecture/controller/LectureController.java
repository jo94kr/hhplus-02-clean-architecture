package io.hhplus.clean_architecture.controller;

import io.hhplus.clean_architecture.controller.dto.LectureApplyResDto;
import io.hhplus.clean_architecture.controller.dto.LectureResDto;
import io.hhplus.clean_architecture.service.LectureService;
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
    ResponseEntity<LectureApplyResDto> apply(@PathVariable(name = "lectureId") Long lectureId, @RequestBody Long userId) {
        LectureApplyResDto resDto = LectureApplyResDto.of(lectureService.apply(lectureId, userId));
        return ResponseEntity.ok().body(resDto);
    }

    @GetMapping
    ResponseEntity<List<LectureResDto>> findAllLectureList() {
        return ResponseEntity.ok().body(lectureService.findAllLectureList().stream()
                .map(LectureResDto::of)
                .toList());
    }
}
