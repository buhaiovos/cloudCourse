package cad.osb.birthdaycountdown.repositories;

import cad.osb.birthdaycountdown.dto.UserDTO;

import java.util.List;

public interface UserRepository {
    UserDTO createUser(UserDTO user);
    UserDTO updateUser(UserDTO user);
    List<UserDTO> allUsers();
    void deleteUser(UserDTO user);
}
