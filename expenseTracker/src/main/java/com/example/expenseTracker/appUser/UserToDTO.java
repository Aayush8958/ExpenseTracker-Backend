package com.example.expenseTracker.appUser;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserToDTO {
    UserDto toDTO(appuser appuser);
    List<UserDto> toDTOList(List<appuser> appuserList);
}
