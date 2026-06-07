package com.example.expenseTracker.appUser;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-06-07T18:48:12+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class UserToDTOImpl implements UserToDTO {

    @Override
    public UserDto toDTO(appuser appuser) {
        if ( appuser == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( appuser.getId() );

        return userDto;
    }

    @Override
    public List<UserDto> toDTOList(List<appuser> appuserList) {
        if ( appuserList == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( appuserList.size() );
        for ( appuser appuser : appuserList ) {
            list.add( toDTO( appuser ) );
        }

        return list;
    }
}
