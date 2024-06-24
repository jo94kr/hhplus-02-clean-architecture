package io.hhplus.clean_architecture.controller;

import io.hhplus.clean_architecture.controller.dto.LectureApplyResDto;
import io.hhplus.clean_architecture.service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lecture")
public class LectureController {

    private final LectureService lectureService;

    @PostMapping("/{lectureId}/apply")
    ResponseEntity<LectureApplyResDto> apply(@PathVariable(name = "lectureId") Long lectureId, @RequestBody Long userId) {
        LectureApplyResDto response = LectureApplyResDto.of(lectureService.apply(lectureId, userId));

        return ResponseEntity.ok().body(response);
    }

}
