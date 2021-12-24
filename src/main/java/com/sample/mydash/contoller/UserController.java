package com.sample.mydash.contoller;

import com.sample.mydash.bean.User;
import com.sample.mydash.exception.UserNotFoundException;
import com.sample.mydash.service.UserDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDAOService userDAOService;

    @GetMapping("/users")
    public List<User> getAllUser() {
        return userDAOService.listAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id) {
        User user = userDAOService.findUser(id);
        if (user == null) {
            throw new UserNotFoundException("UserId: " + id + " was not found.");
        }
        return user;
    }

    @PostMapping(value = "/users/add")
    public ResponseEntity<Object> addUser(@Valid @RequestBody User user) {
        User addedUser = userDAOService.addUser(user);
        URI uriLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(uriLocation).build();
    }

    @DeleteMapping("/users/delete/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable int id) {
        User user = userDAOService.deleteUser(id);

        if (user == null) {
            throw new UserNotFoundException("UserId: " + id + " was not found.");
        }

        return ResponseEntity.noContent().build();
    }
}
