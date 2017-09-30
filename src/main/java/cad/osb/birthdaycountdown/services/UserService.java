package cad.osb.birthdaycountdown.services;

import cad.osb.birthdaycountdown.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO user);
    UserDTO updateUser(UserDTO user);
    List<UserDTO> getAllUsers();
    void deleteUser(UserDTO user);
}
