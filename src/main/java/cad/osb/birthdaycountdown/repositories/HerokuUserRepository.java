package cad.osb.birthdaycountdown.repositories;

import cad.osb.birthdaycountdown.dto.UserDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HerokuUserRepository implements UserRepository {

    private static Logger logger = LogManager.getLogger(HerokuUserRepository.class);

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
        try (Connection conn = getConnection()) {
            logger.info("createUser(): connection retrieved. Creating statement for user:" + user);

            PreparedStatement stmt = conn.prepareStatement("INSERT INTO USERS (NAME, BIRTH_DATE) VALUES (?, ?)");
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getBirthDay());
            int status = stmt.executeUpdate();

            logger.info("createUser(): updateExecuted with " + status);
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public UserDTO updateUser(UserDTO user) {
        try (Connection conn = getConnection()) {
            logger.info("updateUser(): connection retrieved. Creating statement for user:" + user);

            PreparedStatement stmt = conn.prepareStatement("UPDATE USERS SET NAME = ?, BIRTH_DATE = ? WHERE ID = ?");
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getBirthDay());
            stmt.setInt(3, user.getId());
            int status = stmt.executeUpdate();

            logger.info("updateUser(): updateExecuted with " + status);
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public UserDTO getUserById(int id) {
        try (Connection conn = getConnection()) {
            logger.info("getUserById(): connection retrieved. "
                    + "Creating statement");

            PreparedStatement stmt =
                    conn.prepareStatement("SELECT * FROM USERS WHERE ID = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            UserDTO user = new UserDTO();
            user.setId(rs.getInt(1));
            user.setName(rs.getString(2));
            user.setBirthDay(rs.getString(3));

            logger.info("getUserById(): connection retrieved. " +
                    "Returning user: " + user);
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<UserDTO> allUsers() {
        try (Connection conn = getConnection()) {
            logger.info("allUsers(): connection retrieved. "
                        + "Creating statement");

            PreparedStatement stmt =
                    conn.prepareStatement("SELECT * FROM USERS");
            ResultSet rs = stmt.executeQuery();
            ArrayList<UserDTO> usersList = new ArrayList<>();
            while (rs.next()) {
                UserDTO user = new UserDTO();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setBirthDay(rs.getString(3));
                usersList.add(user);
            }

            logger.info("allUsers(): connection retrieved. " +
                    "Returning list with size " + usersList.size());
            return usersList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteUser(UserDTO user) {
        try (Connection conn = getConnection()) {
            logger.info("deleteUser(): connection retrieved. Creating statement for user:" + user);

            PreparedStatement stmt = conn.prepareStatement("DELETE FROM USERS WHERE ID = ?");
            stmt.setInt(1, user.getId());
            int status = stmt.executeUpdate();

            logger.info("deleteUser(): updateExecuted with " + status);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
