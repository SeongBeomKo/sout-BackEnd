package com.seongend.sout.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.seongend.sout.dto.CommentResponseDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class HomeControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private HttpHeaders headers;
    private static ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setup() {
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    @Test
    @Order(1)
    @DisplayName("메인 페이지 로드")
    void test1() throws JsonProcessingException {
        // when
        ResponseEntity<PostResponseDto[]> response = restTemplate.getForEntity(
                "/?page=0&size=3",
                PostResponseDto[].class
        );

        // then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        PostResponseDto[] responsePosts = response.getBody();
        assertNotNull(responsePosts);
    }


    @Getter
    @Setter
    @Builder
    static class PostResponseDto {
        private String nickname;
        private String content;
        private long postId;
        private LocalDateTime modifiedAt;
        private String url;
        private String interest;
        private List<CommentResponseDto> commentList;
        private String email;
    }
}