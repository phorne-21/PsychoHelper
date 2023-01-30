package org.helper.service.user;

import lombok.RequiredArgsConstructor;
import org.helper.enums.Role;
import org.helper.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final Map<UUID, User> usersMap = new HashMap<>();

    @PostConstruct
    private void init() {
        User user1 = new User();
        user1.setId(UUID.fromString("86c7b099-555e-4182-b24d-0f2f559ef91f"));
        user1.setName("Ekaterina");
        user1.setRole(Role.SUPER_ADMIN);
        user1.setEmail("lwrow220816@gmail.com");
        user1.setPassword("1234567");
        usersMap.put(user1.getId(), user1);
        User user2 = new User();
        user2.setId(UUID.randomUUID());
        user2.setName("Evgeni");
        user2.setRole(Role.ADMIN);
        user2.setEmail("lwsdfdgd@gmail.com");
        user2.setPassword("7654321");
        usersMap.put(user2.getId(), user2);
    }

    @Override
    public List<User> add(User user) {
        user.setId(UUID.randomUUID());
        usersMap.put(user.getId(), user);
        return new ArrayList<>(usersMap.values());
    }

    @Override
    public List<User> getAllUsers() {
        return usersMap.values().stream().toList();
    }

    @Override
    public User getUserById(UUID id) {
        return usersMap.get(id);
    }

    @Override
    public User updateUser(User user) {
        usersMap.put(user.getId(), user);
        return usersMap.get(user.getId());
    }

    @Override
    public void deleteUser(UUID id) {
        usersMap.remove(id);
    }
}
