package com.example.expenseTracker.AppUser;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserToDTO {
    UserDto toDTO(Appuser appuser);
    List<UserDto> toDTOList(List<Appuser> appuserList);
}
