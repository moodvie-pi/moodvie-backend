package br.com.moodvie.controller;

import br.com.moodvie.form.UserForm;
import br.com.moodvie.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping()
    public ResponseEntity<?> registerUser(@RequestBody UserForm userForm){
        userService.create(userForm);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
