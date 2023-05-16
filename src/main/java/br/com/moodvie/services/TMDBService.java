package br.com.moodvie.services;

import br.com.moodvie.domain.movie.TMDBResponse;
import br.com.moodvie.repository.TMDBRepository;
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
        Object movieDetails = tmdbRepository.findTMDBDetails(movieId,lang);
        System.out.println(movieDetails.toString());
        return movieDetails;
    }
}
