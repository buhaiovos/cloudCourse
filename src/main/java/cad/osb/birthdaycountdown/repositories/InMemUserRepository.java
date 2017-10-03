package cad.osb.birthdaycountdown.repositories;

import cad.osb.birthdaycountdown.dto.UserDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class InMemUserRepository implements UserRepository {

    private static final Logger logger =
            LogManager.getLogger(InMemUserRepository.class);

    private List<UserDTO> allUsers;
    private static int currentId = 0;

    public InMemUserRepository(List<UserDTO> allUsers) {
        logger.debug("Entering InMemRepo constructor");
        this.allUsers = allUsers;
        logger.debug("Exiting InMemRepo constructor");
    }

    @Override
    public UserDTO createUser(UserDTO user) {
        logger.info("createUser(UserDTO user): Trying to create " + user);
        user.setId(currentId++);

        boolean isAdded = allUsers.add(user);
        if (isAdded) {
            int index = allUsers.indexOf(user);
            return allUsers.get(index);
        }

        logger.info("createUser(UserDTO user): "
                + user + " was not created. Method");
        return null;
    }

    // TODO : finish repository + fill .jsp files with some code

    @Override
    public UserDTO updateUser(UserDTO updatedUser) {
        logger.info("updateUser(UserDTO user): Trying to update " + updatedUser);

        int existingUserIndex = findRepoIndexOfUser(updatedUser);
        allUsers.remove(existingUserIndex);
        allUsers.add(existingUserIndex, updatedUser);
        return allUsers.get(existingUserIndex);
    }

    @Override
    public UserDTO getUserById(int id) {
        logger.info("getUserById(int id): " +
                "Trying to get user with id=" + id);

        UserDTO foundUser =
                allUsers.stream()
                        .filter(u ->  u.getId() == id)
                        .findFirst().orElseThrow(NoSuchUserException::new);
        return foundUser;
    }

    @Override
    public List<UserDTO> allUsers() {
        logger.info("allUsers(): returning list");

        return new ArrayList<>(allUsers);
    }

    @Override
    public void deleteUser(UserDTO user) {
        logger.info("deleteUser(UserDTO user): Trying to delete " + user);

        int deletingUserIndex = findRepoIndexOfUser(user);
        allUsers.remove(deletingUserIndex);
    }

    private int findRepoIndexOfUser(UserDTO user) {
        for (int i = 0; i < allUsers.size(); i++) {
            if (allUsers.get(i).getId() == user.getId()) {
                return i;
            }
        }
        throw new NoSuchUserException();
    }

    private class NoSuchUserException extends RuntimeException {
        public NoSuchUserException() {
            super("No user with specified id");
        }
    }
}
