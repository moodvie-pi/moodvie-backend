package br.com.moodvie.services;

import br.com.moodvie.domain.user.User;
import br.com.moodvie.form.UserForm;
import br.com.moodvie.mappers.UserMapper;
import br.com.moodvie.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    public User findLoggedUser(){
        String loggedUser = SecurityContextHolder.getContext().getAuthentication().getName().trim();
        return userRepository.findUserByUsername(loggedUser)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado!"));
    }

    public void create(UserForm userForm) {
        User user = userMapper.toEntity(userForm);
        PasswordEncoder passwordEncoder =  new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);
    }
}
