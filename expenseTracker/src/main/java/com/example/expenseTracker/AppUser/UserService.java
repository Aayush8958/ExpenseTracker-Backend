package com.example.expenseTracker.AppUser;

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

    public ResponseEntity<String> CreateSignUp(signupRequest signupRequest){
        if(userRepo.existsByName(signupRequest.getName())){
            throw new AlreadyExists("UserName Already exists");
        }
        Appuser appuser=new Appuser();

        String pwd=signupRequest.getPassword();
        String hshpwd= BCrypt.hashpw(pwd,BCrypt.gensalt());
        appuser.setPassword(hshpwd);
        appuser.setName(signupRequest.getName());

        userRepo.save(appuser);
        return ResponseEntity.ok("User registered successfuly");
    }

    public Appuser findAppuserName(String username){
        if(!userRepo.existsByName(username)){
            throw new NotFound("User name doesn't exisits");
        }
        Appuser appuser=userRepo.getByName(username);

        return  appuser;

    }

    public Appuser findById(Long id){
        if(!userRepo.existsById(id)){
            throw new NotFound("User name doesn't exisits");
        }
        Appuser appuser=userRepo.getById(id);

        return appuser;

    }
    public boolean ExistByName(String name ){
        return userRepo.existsByName(name);
    }

}
