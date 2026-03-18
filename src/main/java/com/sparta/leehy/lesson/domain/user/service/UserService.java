package com.sparta.leehy.lesson.domain.user.service;

import com.sparta.leehy.lesson.domain.user.dto.request.UserRequest;
import com.sparta.leehy.lesson.domain.user.dto.response.UserResponse;
import com.sparta.leehy.lesson.domain.user.entity.User;
import com.sparta.leehy.lesson.domain.user.mapper.UserMapper;
import com.sparta.leehy.lesson.domain.user.repository.UserRepository;
import com.sparta.leehy.lesson.global.exception.DomainException;
import com.sparta.leehy.lesson.global.exception.DomainExceptionCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

//@Component // 해당 어노테이션이 붙은 클래스는 스프링 빈으로 등록됨
@Service
@RequiredArgsConstructor // final 키워드가 붙은 전역변수를 생성자로 만들어주는 어노테이션
public class UserService {


    private final UserMapper userMapper;
    //    @Autowired // 필드 주입
    private final UserRepository userRepository; // 목표 : 필드에 인스턴스를 주입하는 것
    private final PasswordEncoder passwordEncoder;

    public List<UserResponse> getAllUsers() {
        return List.of();
    }

    public UserResponse getUserById(Long id) {
        return UserResponse.builder().build();
    }

    public UserResponse save(UserRequest request) {
        // 이메일 중복 체크 로직
        if (!userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new DomainException(DomainExceptionCode.DUPLICATE_EMAIL);
        }

        // password 암호화를 위해서
        String encodePassword = passwordEncoder.encode(request.getPassword());

        User user = userRepository.save(userMapper.toEntity(request, encodePassword));    // id, 자동생성 필드 값이 있는 상태

        return userMapper.toUserResponse(user);
    }

}


// 개선점 1. 인스턴스에 생성과 해제를 최소화 해야한다. -> 스프링 빈에 등록하고 impl를 이용하면 이 2가지 모두 해결됨
// 개선점 2. 수정 작업한 한 코드만 고치는 것이 아닌 참조를 하고 있는 모든 클래스를 수정하는 상황
