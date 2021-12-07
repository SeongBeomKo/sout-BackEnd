package com.seongend.sout.entity;

import com.seongend.sout.dto.SignupRequestDto;
import com.seongend.sout.validator.UserInfoValidator;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@Getter
@Entity
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    // 사용자 Email == 사용자 ID
    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String interest;

    @Column
    private Long kakaoId;

    public User(SignupRequestDto requestDto, String enPassword){
        UserInfoValidator.validateUserInfoInput(requestDto);

        this.username = requestDto.getEmail();
        this.nickname = requestDto.getNickname();
        this.password = enPassword;
        this.interest = requestDto.getInterest();
    }

    public User(String nickname, String encodedPassword, String email, Long kakaoId) {
        this.username = email;
        this.nickname = nickname;
        this.password = encodedPassword;
        this.interest = "미설정";
        this.kakaoId = kakaoId;
    }

    public void update(SignupRequestDto requestDto, String enPassword) {
        UserInfoValidator.validateUserInfoInput(requestDto);

        this.username = requestDto.getEmail();
        this.nickname = requestDto.getNickname();
        this.password = enPassword;
        this.interest = requestDto.getInterest();
    }
}
