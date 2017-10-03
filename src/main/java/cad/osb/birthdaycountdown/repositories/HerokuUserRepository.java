package cad.osb.birthdaycountdown.repositories;

import cad.osb.birthdaycountdown.dto.UserDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HerokuUserRepository implements UserRepository {

    String dbUrl = "jdbc:postgresql://ec2-50-17-203-195.compute-1.amazonaws.com:5432/dbor3ci1tlb8a9?user=rkzhwbnwnffqqz&password=589eef7a8229f62f4f6e82c9f8837eb1dbcbf7bfab43b82cd3c9301571f6d646&sslmode=require";

    private Connection getConnection() {
        try {
            String url = System.getenv("JDBC_DATABASE_URL");
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public UserDTO createUser(UserDTO user) {
        throw new UnsupportedOperationException("Heroku repo");
    }

    @Override
    public UserDTO updateUser(UserDTO user) {
        throw new UnsupportedOperationException("Heroku repo");
    }

    @Override
    public UserDTO getUserById(int id) {
        throw new UnsupportedOperationException("Heroku repo");
    }

    @Override
    public List<UserDTO> allUsers() {
        try (Connection conn = getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM USERS");

            ArrayList<UserDTO> usersList = new ArrayList<>();

            while (rs.next()) {
                UserDTO user = new UserDTO();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setBirthDay(rs.getString(3));
                usersList.add(user);
            }

            return usersList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteUser(UserDTO user) {
        throw new UnsupportedOperationException("Heroku repo");
    }
}
