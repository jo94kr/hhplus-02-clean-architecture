package io.hhplus.clean_architecture.controller;

import io.hhplus.clean_architecture.IntegratedTest;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.jdbc.Sql;


@Sql("classpath:/db/create_lecture.sql")
class LectureControllerIntegratedTest extends IntegratedTest {

    private static final String PATH = "/lecture";

    @Test
    @DisplayName("POST /lecture/apply 호출")
    void apply() {
        // given
        Long userId = 1L;

        // when
        ExtractableResponse<Response> response = post(PATH + "/" + 1L + "/apply", userId);

        // then
        Assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    }
}
