package org.helper.service.user;

import org.helper.model.User;

import java.util.List;
import java.util.UUID;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(UUID id);

    User updateUser(User user);

    void deleteUser(UUID id);

    List<User> add(User user);
}
