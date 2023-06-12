package br.com.moodvie.controller;

import br.com.moodvie.domain.contentList.Types;
import br.com.moodvie.dto.MoodDTO;
import br.com.moodvie.form.MoodForm;
import br.com.moodvie.services.MoodService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mood")
@AllArgsConstructor
public class MoodController {
    private final MoodService moodService;

    @PostMapping()
    public ResponseEntity<?> saveMood(@RequestBody MoodForm moodForm) {
        moodService.create(moodForm);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<MoodDTO>> findMoods(@RequestParam String lang, @RequestParam Types contentType) {
        List<MoodDTO> moods = moodService.findMoods(lang, contentType);
        return new ResponseEntity<>(moods, HttpStatus.OK);
    }
}
