package com.sparta.leehy.lesson.domain.user.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;

@Entity
@Getter // getter는 괜찮은데 setter는 절대 쓰지말라! (setter는 만드는 것을 권장함)
@DynamicInsert  // insert 쿼리를 생성할 때 ex: 특정칼럼에 null이 있어도 되는경우, null이 아닌쿼리문 모아서 insert해줌
@DynamicUpdate   // 변경된 필드만으로 UPDATE 쿼리를 생성합니다.
@Table(name = "users")
@NoArgsConstructor // 인자가없는 빈생성자를 만들어줌(protected로)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 자번체번일 경우: IDENTITY
    private Long id;

    @Column(nullable = true, length = 50)
    private String name;

    @Column(nullable = true, unique = true)  // not null
    private String email;

    @Column(nullable = true)
    private String password;

    @Column(updatable = false) // 한번 들어가면 그 이후로 update X
    @CreationTimestamp // 데이터가 생성될때 생성된 시점에 딱 알아서 해당시간을 데이터를 넣어줌
    private LocalDateTime createdAt;


    @Builder
    public User(
            String name,
            String email,
            String password
    ) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

}
