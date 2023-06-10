package br.com.moodvie.controller;

import br.com.moodvie.form.MoodForm;
import br.com.moodvie.services.MoodService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mood")
@AllArgsConstructor
public class MoodController {
    private final MoodService moodService;
    @PostMapping()
    public ResponseEntity<?> saveMood(@RequestBody MoodForm moodForm){
        moodService.create(moodForm);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
