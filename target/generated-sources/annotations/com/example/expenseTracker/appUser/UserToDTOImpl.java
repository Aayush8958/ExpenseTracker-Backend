package com.example.expenseTracker.AppUser;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-06-13T15:14:38+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class UserToDTOImpl implements UserToDTO {

    @Override
    public UserDto toDTO(Appuser appuser) {
        if ( appuser == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( appuser.getId() );

        return userDto;
    }

    @Override
    public List<UserDto> toDTOList(List<Appuser> appuserList) {
        if ( appuserList == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( appuserList.size() );
        for ( Appuser appuser : appuserList ) {
            list.add( toDTO( appuser ) );
        }

        return list;
    }
}
