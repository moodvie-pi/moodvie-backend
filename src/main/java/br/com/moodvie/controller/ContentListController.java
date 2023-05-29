package br.com.moodvie.controller;

import br.com.moodvie.form.ContentListForm;
import br.com.moodvie.repository.UserRepository;
import br.com.moodvie.services.ContentListService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contentList")
@AllArgsConstructor
public class ContentListController {
    private final ContentListService contentListService;

    private final UserRepository userRepository;

    @PostMapping
    public ResponseEntity<?> saveContentList(@RequestBody ContentListForm contentListForm) {
        this.contentListService.create(contentListForm);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
