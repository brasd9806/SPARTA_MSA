package com.sparta.leehy.lesson.domain.user.mapper;

import com.sparta.leehy.lesson.domain.user.dto.request.UserRequest;
import com.sparta.leehy.lesson.domain.user.dto.response.UserResponse;
import com.sparta.leehy.lesson.domain.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "username", source = "name")
    UserResponse toUserResponse(User user);

    @Mapping(target = "password", source = "password")
    User toEntity(UserRequest user, String password);
}

