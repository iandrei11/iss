package repo.interfaces;

import model.AuthUserDTO;
import model.User;
import repo.Repo;

import java.util.Optional;

public interface UserRepo extends Repo<Long, User> {

    public Optional<AuthUserDTO> authenticate(String username, String password);


}
