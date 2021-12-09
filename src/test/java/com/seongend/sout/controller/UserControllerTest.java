package com.seongend.sout.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.*;

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
    @DisplayName("회원 가입")
    void test1() throws JsonProcessingException{
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

    @Nested
    @DisplayName("로그인, JWT 토큰 받기")
    class RegisterRestaurants {
        @Test
        @DisplayName("로그인")
        void test1() throws JsonProcessingException{
            // given
            String requestBody = objectMapper.writeValueAsString(user1Login);
            HttpEntity<String> request = new HttpEntity<>(requestBody, headers);

            // when
            ResponseEntity<Object> response = restTemplate.postForEntity(
                    "/user/login",
                    request,
                    Object.class);

            // then
            assertEquals(HttpStatus.OK, response.getStatusCode());
            System.out.println(response.getHeaders());
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
}