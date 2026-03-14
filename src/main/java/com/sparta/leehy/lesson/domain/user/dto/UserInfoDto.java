package com.sparta.leehy.lesson.domain.user.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserInfoDto {

    Long id;
    String name;
    String email;
    Boolean isActive; // DB에 없는 칼럼. 여기서 이사용자가 탈퇴한 회원인지 검증함

    @Builder
    public UserInfoDto(
            Long id,
            String name,
            String email,
            Boolean isActive
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.isActive = isActive;
    }

}
