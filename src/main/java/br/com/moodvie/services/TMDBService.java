package br.com.moodvie.services;

import br.com.moodvie.domain.movie.ContentDetailsTMDB;
import br.com.moodvie.domain.movie.SimplifiedContentTMDB;
import br.com.moodvie.domain.movie.TMDBResponse;
import br.com.moodvie.repository.TMDBRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
public class TMDBService {
    private final TMDBRepository tmdbRepository;

    public TMDBResponse getRecommendation(String type, Integer contentId,Integer pageNumber,String lang){
        return tmdbRepository.findTMDBrecommendations(type,contentId,pageNumber,lang);
    }

    public ContentDetailsTMDB getMovieDetails(String type, Integer contentId,String lang){
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
