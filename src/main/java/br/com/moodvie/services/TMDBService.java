package br.com.moodvie.services;

import br.com.moodvie.domain.mood.Mood;
import br.com.moodvie.domain.mood.MoodTypes;
import br.com.moodvie.domain.movie.ContentDetailsTMDB;
import br.com.moodvie.domain.movie.SimplifiedContentTMDB;
import br.com.moodvie.domain.movie.TMDBResponse;
import br.com.moodvie.domain.user.User;
import br.com.moodvie.mappers.TypeMapper;
import br.com.moodvie.repository.MoodRepository;
import br.com.moodvie.repository.TMDBRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@AllArgsConstructor
@Service
public class TMDBService {
    private final TMDBRepository tmdbRepository;
    private final MoodRepository moodRepository;
    private final TypeMapper typeMapper;
    private final UserService userService;

    public TMDBResponse getRecommendation(String type, MoodTypes mood, Integer pageNumber, String lang){
        User user = userService.findLoggedUser();
        Mood foundMood = moodRepository.findByTypeUserMood(typeMapper.toTypes(type),user,mood).orElseThrow(()-> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
        return tmdbRepository.findTMDBrecommendations(type,foundMood.getContentId(),pageNumber,lang);
    }

    public ContentDetailsTMDB getMovieDetails(String type, Long contentId, String lang){
        Object movieDetailsObject = tmdbRepository.findTMDBDetails(type,contentId,lang);
        ContentDetailsTMDB movieDetails;
        try{
            ObjectMapper objectMapper =  new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            String jsonString = objectMapper.writeValueAsString(movieDetailsObject);
            System.out.println(jsonString);
            movieDetails = objectMapper.readValue(jsonString, ContentDetailsTMDB.class);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return movieDetails;
    }

    public List<SimplifiedContentTMDB> findMovieByQuery(String type, String lang, String query){
        return tmdbRepository.findMovieByQuery(type, lang, query).getResults().stream().map((result)-> new SimplifiedContentTMDB(
                result.getAdult(),
                result.getBackdrop_path(),
                result.getId(),
                result.getTitle(),
                result.getName(),
                result.getRelease_date(),
                result.getFirst_air_date())).toList();
    }

}
