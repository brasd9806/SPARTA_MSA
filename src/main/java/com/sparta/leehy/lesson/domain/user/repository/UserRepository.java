package com.sparta.leehy.lesson.domain.user.repository;

import com.sparta.leehy.lesson.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// 기능 정의

// JpaRepository<T, ID>
// T: 리포지토리에서 다룰 엔티티 클래스 (예: User)
// ID: 해당 엔티티의 Primary Key 필드 타입 (예: Long)
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // 이 안에 코드가 없어도 아래의 주요 메서드들을 바로 주입받아 사용할 수 있습니다.

//    // SELECT * FROM users WHERE u.email = "입력 값"
//    @Query("SELECT u FROM User u WHERE u.name = :name")
//    // User는 엔티티이름을 넣어야한다
//    Optional<User> findByEmailOrName(@Param("name") String name);


}
