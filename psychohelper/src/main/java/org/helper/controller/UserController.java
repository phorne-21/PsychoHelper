package org.helper.controller;

import lombok.RequiredArgsConstructor;
import org.helper.model.User;
import org.helper.service.user.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user/")
public class UserController {
    private final UserService userService;

    @PostMapping()
    public List<User> create(@Valid @RequestBody User user) {
        return userService.add(user);
    }

    @GetMapping()
    public List<User> getAll() {
        return userService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getById(@PathVariable UUID id) { // или @RequestBody UUID id ?
        return userService.getUserById(id);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable UUID id) {
        userService.deleteUser(id);
    }

    @PatchMapping
    public User update(@Valid @RequestBody User user) {
        return userService.updateUser(user);
    }
}
