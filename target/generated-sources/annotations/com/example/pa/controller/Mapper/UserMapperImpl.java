package com.example.pa.controller.Mapper;

import com.example.pa.User.User;
import com.example.pa.controller.DTO.UserDTO.UserProfileDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-17T21:37:46-0300",
    comments = "version: 1.6.2, compiler: Eclipse JDT (IDE) 3.41.0.z20250115-2156, environment: Java 21.0.5 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserProfileDTO toUserProfileDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserProfileDTO userProfileDTO = new UserProfileDTO();

        userProfileDTO.setDireccionEnvio( user.getDireccionEnvio() );
        userProfileDTO.setEmail( user.getEmail() );
        userProfileDTO.setFirstname( user.getFirstname() );
        userProfileDTO.setLastname( user.getLastname() );
        userProfileDTO.setTelefono( user.getTelefono() );

        return userProfileDTO;
    }

    @Override
    public User toUser(UserProfileDTO userProfileDTO, User user) {
        if ( userProfileDTO == null ) {
            return user;
        }

        user.setDireccionEnvio( userProfileDTO.getDireccionEnvio() );
        user.setEmail( userProfileDTO.getEmail() );
        user.setFirstname( userProfileDTO.getFirstname() );
        user.setLastname( userProfileDTO.getLastname() );
        user.setTelefono( userProfileDTO.getTelefono() );

        return user;
    }
}
