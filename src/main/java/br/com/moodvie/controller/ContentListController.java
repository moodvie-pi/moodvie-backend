package br.com.moodvie.controller;

import br.com.moodvie.domain.contentList.ContentListTypes;
import br.com.moodvie.domain.user.User;
import br.com.moodvie.dto.ContentListDTO;
import br.com.moodvie.repository.UserRepository;
import br.com.moodvie.services.ContentListService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/contentList")
@AllArgsConstructor
public class ContentListController {
    private final ContentListService contentListService;

    private final UserRepository userRepository;

    @PostMapping
    public ResponseEntity<?> saveContentList(@RequestBody ContentListDTO contentListDTO) {

        String loggedUser = SecurityContextHolder.getContext().getAuthentication().getName().trim();
        User user = userRepository.findUserByUsername(loggedUser)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado!"));

        this.contentListService.create(user, contentListDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
