package io.hhplus.clean_architecture.controller;

import io.hhplus.clean_architecture.IntegratedTest;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.jdbc.Sql;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.assertj.core.api.Assertions.assertThat;

@Sql("classpath:/db/create_lecture.sql")
class LectureControllerIntegratedTest extends IntegratedTest {

    private static final String PATH = "/lectures";

    @Test
    @DisplayName("POST /lecture/apply 호출")
    void apply() {
        // given
        Long userId = 1L;

        // when
        ExtractableResponse<Response> response = post(PATH + "/" + 1L + "/apply", userId);

        // then
        assertThat(response.statusCode()).isEqualTo(HttpStatus.NO_CONTENT.value());
    }

    @Test
    @DisplayName("정원이 30명인 특강 동시에 35명 신청 요청 호출")
    void concurrency_applyMoreThanCapacity() {
        // given
        // when
        int cnt = 35;
        CompletableFuture<Integer>[] futureArray = new CompletableFuture[cnt];
        for (int i = 0; i < cnt; i++) {
            final int userId = i + 1;
            futureArray[i] = CompletableFuture.supplyAsync(() -> {
                ExtractableResponse<Response> post = post(PATH + "/" + 1L + "/apply", userId);
                return post.statusCode();
            });
        }
        CompletableFuture.allOf(futureArray).join();

        // then
        List<Integer> failCnt = Arrays.stream(futureArray)
                .map(CompletableFuture::join)
                .filter(statusCode -> statusCode != HttpStatus.NO_CONTENT.value())
                .toList();

        assertThat(failCnt).hasSize(5);
    }

    @Test
    @DisplayName("특강 목록 조회")
    void findAllLecture() {
        // given
        // when
        ExtractableResponse<Response> response = get(PATH);

        // then
        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    }
}
