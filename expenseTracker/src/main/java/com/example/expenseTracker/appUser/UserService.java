package com.example.expenseTracker.appUser;

import com.example.expenseTracker.ExceptionS.AlreadyExists;
import com.example.expenseTracker.ExceptionS.NotFound;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepo userRepo;
    private UserToDTO userToDTO;

    public UserService(UserRepo userRepo, UserToDTO userToDTO) {
        this.userRepo = userRepo;
        this.userToDTO = userToDTO;
    }

    public ResponseEntity<String> SignUp(appuser appuser){
        if(userRepo.existsByName(appuser.getName())){
            throw new AlreadyExists("UserName Already exists");
        }
        String pwd=appuser.getPassword();
        String hshpwd= BCrypt.hashpw(pwd,BCrypt.gensalt());
        appuser.setPassword(hshpwd);
        userRepo.save(appuser);
        return ResponseEntity.ok("User registered successfuly");
    }

    public UserDto findByName(String username){
        if(!userRepo.existsByName(username)){
            throw new NotFound("User name doesn't exisits");
        }
        appuser appuser=userRepo.getByName(username);

    return    userToDTO.toDTO(appuser);

    }
    public appuser findById(Long id){
        if(!userRepo.existsById(id)){
            throw new NotFound("User name doesn't exisits");
        }
        appuser appuser=userRepo.getById(id);

        return appuser;

    }

}
