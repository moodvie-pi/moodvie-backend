package br.com.moodvie.services;

import br.com.moodvie.domain.movie.MovieDetailsTMDB;
import br.com.moodvie.domain.movie.TMDBResponse;
import br.com.moodvie.domain.movie.watchproviders.WatchProviders;
import br.com.moodvie.repository.TMDBRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class TMDBService {
    private final TMDBRepository tmdbRepository;

    public TMDBResponse getRecommendation(Integer movieId,Integer pageNumber,String lang){
        return tmdbRepository.findTMDBrecommendations(movieId,pageNumber,lang);
    }

    public Object getMovieDetails(Integer movieId,String lang){
        Object movieDetailsObject = tmdbRepository.findTMDBDetails(movieId,lang);
        MovieDetailsTMDB movieDetails;
        try{
            ObjectMapper objectMapper =  new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            String jsonString = objectMapper.writeValueAsString(movieDetailsObject);
            System.out.println(jsonString);
            movieDetails = objectMapper.readValue(jsonString,MovieDetailsTMDB.class);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return movieDetails;
    }
}
