package com.seongend.sout.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    private HttpHeaders headers;
    private static ObjectMapper objectMapper = new ObjectMapper();

    private String token = "";

    private UserInfoDto user1 = UserInfoDto.builder()
            .id(null)
            .email("xxx@naver.com")
            .nickname("diddl")
            .interest("Web-Fullstack")
            .password("tjddms1234")
            .build();

    private LoginRequestDto user1Login = LoginRequestDto.builder()
            .username("xxx@naver.com")
            .password("tjddms1234")
            .build();

    @BeforeEach
    public void setup() {
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    @Test
    @Order(1)
    @DisplayName("회원 가입")
    void test1() throws JsonProcessingException {
        // given
        String requestBody = objectMapper.writeValueAsString(user1);
        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);

        // when
        ResponseEntity<Object> response = restTemplate.postForEntity(
                "/user/signup",
                request,
                Object.class);

        // then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    @Order(2)
    @DisplayName("로그인, JWT 토큰 받기")
    void test2() throws JsonProcessingException {
        // given
        String requestBody = objectMapper.writeValueAsString(user1Login);
        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);

        // when
        ResponseEntity<Object> response = restTemplate.postForEntity(
                "/user/login",
                request,
                Object.class);

        // then
        token = response.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Nested
    @DisplayName("JWT 토큰 인가 - 유저 정보 수정")
    class JWTtest {
        @Test
        @DisplayName("유저 정보 수정")
        void test2() throws JsonProcessingException {
            // given
            UserInfoDto userUpdate = UserInfoDto.builder()
                    .id(null)
                    .email("xxx@naver.com")
                    .nickname("diddl61")
                    .interest("Web-BackEnd")
                    .password("tjddms1234")
                    .build();

            String requestBody = objectMapper.writeValueAsString(userUpdate);
            headers.set("Authorization", token);
            HttpEntity<String> request = new HttpEntity<>(requestBody, headers);

            // when
            ResponseEntity<Object> response = restTemplate.postForEntity(
                    "/userinfo",
                    request,
                    Object.class);

            // then
            assertEquals(HttpStatus.OK, response.getStatusCode());
        }
    }

    @Getter
    @Setter
    @Builder
    static class UserInfoDto {
        private Long id;
        private String email;
        private String nickname;
        private String interest;
        private String password;
    }

    @Getter
    @Setter
    @Builder
    static class LoginRequestDto {
        private String username;
        private String password;
    }

    @Getter
    @Setter
    @Builder
    static class PostRequestDto {
        private String content;
        private String url;
    }
}