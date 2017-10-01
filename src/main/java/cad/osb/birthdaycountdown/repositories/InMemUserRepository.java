package cad.osb.birthdaycountdown.repositories;

import cad.osb.birthdaycountdown.dto.UserDTO;

import java.util.List;
import java.util.Set;

public class InMemUserRepository implements UserRepository {

    List<UserDTO> allUsers;

    public InMemUserRepository(List<UserDTO> allUsers) {
        this.allUsers = allUsers;
    }

    @Override
    public UserDTO createUser(UserDTO user) {
        boolean isAdded = allUsers.add(user);
        if (isAdded) {
            int index = allUsers.indexOf(user);
            return allUsers.get(index);
        }
        return null;
    }

    @Override
    public UserDTO updateUser(UserDTO user) {
        return null;
    }

    @Override
    public UserDTO getUserById(int id) {
        return null;
    }

    @Override
    public List<UserDTO> allUsers() {
        return null;
    }

    @Override
    public void deleteUser(UserDTO user) {

    }
}
