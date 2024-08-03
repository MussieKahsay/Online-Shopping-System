package edu.miu.cs.cs425.controller;

import edu.miu.cs.cs425.dto.AdminDto;
import edu.miu.cs.cs425.dto.UserDto;
import edu.miu.cs.cs425.model.User;
import edu.miu.cs.cs425.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ecom/admin")
@RequiredArgsConstructor
public class AdminController {

    private  UserService userService;

    private  PasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody AdminDto user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User addedUser = userService.addUserAdmin(user);
        return ResponseEntity.ok(addedUser);
    }

    @PutMapping("/updatepassword/{adminId}")
    public ResponseEntity<User> updateUserPassword(@PathVariable("adminId") Integer customerId, @RequestBody UserDto userdto) {
        User updatedUser = userService.changePassword(customerId, userdto);
        return ResponseEntity.ok(updatedUser);
    }


}