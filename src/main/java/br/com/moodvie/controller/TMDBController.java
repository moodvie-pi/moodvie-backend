package br.com.moodvie.controller;

import br.com.moodvie.domain.movie.TMDBResponse;
import br.com.moodvie.services.TMDBService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/tmdb")
public class TMDBController {

    private final TMDBService tmdbService;

    @ResponseBody
    @GetMapping("/recommendations/{movieId}/{pageNumber}/{lang}")
    ResponseEntity<TMDBResponse> getTMDBRecommendation(@PathVariable Integer movieId, @PathVariable Integer pageNumber, @PathVariable String lang){
        return new ResponseEntity<>(tmdbService.getRecommendation(movieId,pageNumber,lang), HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/details/{movieId}/{lang}")
    ResponseEntity<Object> getMovieDetails(@PathVariable Integer movieId, @PathVariable String lang){
        return new ResponseEntity<>(tmdbService.getMovieDetails(movieId,lang), HttpStatus.OK);
    }

}
