package br.com.moodvie.controller;

import br.com.moodvie.domain.mood.MoodTypes;
import br.com.moodvie.domain.movie.ContentDetailsTMDB;
import br.com.moodvie.domain.movie.SimplifiedContentTMDB;
import br.com.moodvie.domain.movie.TMDBResponse;
import br.com.moodvie.services.TMDBService;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/tmdb")
public class TMDBController {

    private final TMDBService tmdbService;

    @ResponseBody
    @GetMapping("/recommendations/{type}/{mood}/{pageNumber}/{lang}")
    ResponseEntity<TMDBResponse> getTMDBRecommendation(@PathVariable String type, @PathVariable MoodTypes mood, @PathVariable Integer pageNumber, @PathVariable String lang) {
        return new ResponseEntity<>(tmdbService.getRecommendation(type, mood, pageNumber, lang), HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/details/{type}/{contentId}/{lang}")
    ResponseEntity<ContentDetailsTMDB> getContentDetails(@PathVariable String type, @PathVariable Long contentId, @PathVariable String lang) {
        return new ResponseEntity<>(tmdbService.getMovieDetails(type, contentId, lang), HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/query/{type}/{lang}")
    ResponseEntity<List<SimplifiedContentTMDB>> findContentByQuery(@PathVariable String type, @PathVariable String lang, @Param("query") String query) {
        return new ResponseEntity<>(tmdbService.findMovieByQuery(type, lang, query), HttpStatus.OK);
    }
}
