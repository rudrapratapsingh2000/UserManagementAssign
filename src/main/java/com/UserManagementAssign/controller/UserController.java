package com.UserManagementAssign.controller;

import com.UserManagementAssign.model.User;
import com.UserManagementAssign.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class UserController {

    @Autowired
    UserService userService;


    //read
    @GetMapping("users")
    List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    //create

    @PostMapping("users")
    String addUsers(@RequestBody @Valid List<User> users) {
        return userService.createUsers(users);
    }

    @PostMapping("user")
    String addUser(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }

    //delete :
    @DeleteMapping("user")
    String removeUser(@RequestParam @Max(10000) Integer id) {
        return userService.removeUser(id);
    }

    @RequestMapping(value = "user/{id}/email/{emailId}", method = RequestMethod.PUT)
    String updateEmail(@PathVariable Integer id, @PathVariable @Email String emailId) {
        return userService.updateEmail(id, emailId);
    }
}
