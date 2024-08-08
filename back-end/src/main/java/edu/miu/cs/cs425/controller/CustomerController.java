package edu.miu.cs.cs425.controller;

import edu.miu.cs.cs425.dto.CustomerDto;
import edu.miu.cs.cs425.dto.UserDto;
import edu.miu.cs.cs425.model.User;
import edu.miu.cs.cs425.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ecom/customers")
public class CustomerController {

    private  UserService userService;

    private  PasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity<User> addUser(@Valid @RequestBody CustomerDto user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User addedUser = userService.addUser(user);
        return ResponseEntity.ok(addedUser);
    }

    @PutMapping("/update-password/{customerId}")
    public ResponseEntity<User> updateUserPassword(@PathVariable("customerId") Integer customerId,
                                                   @Valid @RequestBody UserDto userdto) {
        User updatedUser = userService.changePassword(customerId, userdto);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/deactivate/{customerid}")
    public ResponseEntity<String> deactivateUser(@PathVariable("customerid") Integer customerId) {
        System.out.println("inside the deactivate method");
        String message = userService.deactivateUser(customerId);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/{customerid}")
    public ResponseEntity<User> getUserDetails(@PathVariable("customerid") Integer customerId) {
        User user = userService.getUserDetails(customerId);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/get-all-customer")
    public ResponseEntity<List<User>> getAllUserDetails() {
        List<User> users = userService.getAllUserDetails();
        return ResponseEntity.ok(users);
    }

}