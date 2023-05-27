package br.com.moodvie.services;

import br.com.moodvie.domain.user.User;
import br.com.moodvie.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    public User findLoggedUser(){
        String loggedUser = SecurityContextHolder.getContext().getAuthentication().getName().trim();
        return userRepository.findUserByUsername(loggedUser)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado!"));
    }
}
