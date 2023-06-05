package repo.BD;

import model.AuthUserDTO;
import model.User;
import model.UserType;
import repo.interfaces.UserRepo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class UserRepoBD implements UserRepo {


    private JdbcUtils dbUtils;
    public UserRepoBD(Properties properties) {
        dbUtils = new JdbcUtils(properties);
    }


    @Override
    public List<User> getAll() {
        Connection connection = dbUtils.getConnection();
        List<User> userList = new ArrayList<>();
        try (PreparedStatement preparedStatement
                     = connection.prepareStatement("select * from users");
        ) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                UserType userPrivilege = UserType.valueOf(resultSet.getString("usertype"));
                String password = ":DDD";
//                String passwordHash = resultSet.getString("passwordHash");
                User newUser = new User(0L, username, password, userPrivilege);

                userList.add(newUser);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return userList;
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
//        return Optional.of(new AuthUserDTO(0L,"Yep", UserType.Sef));
//        return Optional.empty();

        Connection connection = dbUtils.getConnection();
//        try
//        {
//            System.out.println(connection.getMetaData().getURL());
//        }
//        catch (SQLException e){
//        }

        AuthUserDTO authUserDTO = null;
        try (PreparedStatement preparedStatement
                     = connection.prepareStatement("select * from users where username=? and password=? ");
        ) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
//            System.out.println("yep queried");
            if (resultSet.next()) {
                Long uid = resultSet.getLong("uid");
                String fullname = resultSet.getString("fullname");
                UserType userType = UserType.valueOf(resultSet.getString("usertype"));
                authUserDTO = new AuthUserDTO(uid, fullname, userType);
//                System.out.print("yep amtch");
//                System.out.print(authUserDTO);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    return Optional.ofNullable(authUserDTO);


    }
}
