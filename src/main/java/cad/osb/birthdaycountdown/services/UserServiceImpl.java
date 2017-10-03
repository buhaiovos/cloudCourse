package cad.osb.birthdaycountdown.services;

import cad.osb.birthdaycountdown.dto.UserDTO;
import cad.osb.birthdaycountdown.repositories.UserRepository;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO createUser(UserDTO user) {
        return userRepository.createUser(user);
    }

    @Override
    public UserDTO updateUser(UserDTO user) {
        return userRepository.updateUser(user);
    }

    @Override
    public UserDTO getUserById(int id) {
        return userRepository.getUserById(id);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.allUsers();
    }

    @Override
    public void deleteUser(UserDTO user) {
        userRepository.deleteUser(user);
    }

    @Override
    public long getBirthdayCountDown(int id) {
        return 0;
    }
}
