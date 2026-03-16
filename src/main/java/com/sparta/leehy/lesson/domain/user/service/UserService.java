package com.sparta.leehy.lesson.domain.user.service;

import com.sparta.leehy.lesson.domain.user.entity.User;
import com.sparta.leehy.lesson.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

//@Component // 해당 어노테이션이 붙은 클래스는 스프링 빈으로 등록됨
@Service
@RequiredArgsConstructor // final 키워드가 붙은 전역변수를 생성자로 만들어주는 어노테이션
public class UserService {

    //    @Autowired // 필드 주입
    private final UserRepository userRepository; // 목표 : 필드에 인스턴스를 주입하는 것

    public void save() {
        User user = userRepository.findById(1L).get();
    }

    public void update() {

    }
    

}


// 개선점 1. 인스턴스에 생성과 해제를 최소화 해야한다. -> 스프링 빈에 등록하고 impl를 이용하면 이 2가지 모두 해결됨
// 개선점 2. 수정 작업한 한 코드만 고치는 것이 아닌 참조를 하고 있는 모든 클래스를 수정하는 상황
