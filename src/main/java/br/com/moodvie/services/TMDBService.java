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
    private final UserService userService;

    public TMDBResponse getRecommendation(String type, MoodTypes mood, Integer pageNumber, String lang){
        type = type.toLowerCase();
        User user = userService.findLoggedUser();
        Mood foundMood = moodRepository.findByTypeUserMood(TypeMapper.toTypes(type),user,mood).orElseThrow(()-> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
        TMDBResponse response = tmdbRepository.findTMDBrecommendations(type,foundMood.getContentId(),pageNumber,lang);
        response.getResults().forEach((r)->{
            if(r.getTitle() == null)
                r.setTitle(r.getName());
            if(r.getRelease_date() == null)
                r.setRelease_date(r.getFirst_air_date());
        });

        return response;
    }

    public ContentDetailsTMDB getMovieDetails(String type, Long contentId, String lang){
        type = type.toLowerCase();
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
        if(movieDetails.getTitle()==null)
            movieDetails.setTitle(movieDetails.getName());
        if(movieDetails.getRelease_date()==null)
            movieDetails.setRelease_date(movieDetails.getFirst_air_date());
        return movieDetails;
    }

    public List<SimplifiedContentTMDB> findMovieByQuery(String type, String lang, String query){
        type = type.toLowerCase();
        List<SimplifiedContentTMDB> response = tmdbRepository.findMovieByQuery(type, lang, query).getResults().stream().map((result)-> new SimplifiedContentTMDB(
                result.getAdult(),
                result.getBackdrop_path(),
                result.getId(),
                result.getTitle(),
                result.getName(),
                result.getRelease_date(),
                result.getFirst_air_date())).toList();

        response.forEach((r)->{
            if(r.getTitle() == null)
                r.setTitle(r.getName());
            if(r.getRelease_date() == null)
                r.setRelease_date(r.getFirst_air_date());
        });

        return response;
    }

}
