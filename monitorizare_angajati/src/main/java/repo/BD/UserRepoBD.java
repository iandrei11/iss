package repo.BD;

import model.AuthUserDTO;
import model.User;
import model.UserType;
import repo.interfaces.UserRepo;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class UserRepoBD implements UserRepo {
    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public boolean delete(User storableEntity) throws IOException {
        return false;
    }

    @Override
    public User update(User storableEntity) throws IOException {
        return null;
    }

    @Override
    public User save(User storableEntity) throws IOException {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Optional<AuthUserDTO> authenticate(String username, String password) {
//        return Optional.of(new AuthUserDTO(0L,"Heh", UserType.Angajat));
        return Optional.of(new AuthUserDTO(0L,"Yep", UserType.Sef));
//        return Optional.empty();
    }
}
