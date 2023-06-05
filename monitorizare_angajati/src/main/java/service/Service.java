package service;

import model.AuthUserDTO;
import model.UserType;
import repo.interfaces.UserRepo;

import java.util.Optional;

public class Service {
    public Service(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    private UserRepo userRepo;
    public Optional<AuthUserDTO> authenticate(String username, String password){
        return userRepo.authenticate(username,password);
//        return new Optional<null>;
    }

}
