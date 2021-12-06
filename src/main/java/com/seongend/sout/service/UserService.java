package com.seongend.sout.service;

import com.seongend.sout.dto.SignupRequestDto;
import com.seongend.sout.entity.User;
import com.seongend.sout.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public void registerUser(SignupRequestDto requestDto){
        // 이메일이 곧 사용자 ID
        String email = requestDto.getEmail();
        if(userRepository.existsByUsername(email)){
            throw new IllegalArgumentException("중복된 닉네임 입니다.");
        }

        // 패스워드
        String enPassword = passwordEncoder.encode(requestDto.getPassword());

        // 유저 생성
        User user = new User(requestDto, enPassword);
        userRepository.save(user); // DB 저장
    }
}
