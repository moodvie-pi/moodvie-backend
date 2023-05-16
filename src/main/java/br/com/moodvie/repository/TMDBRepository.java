package br.com.moodvie.repository;

import br.com.moodvie.domain.movie.MovieTMDB;
import br.com.moodvie.domain.movie.TMDBResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class TMDBRepository {
    @Value("${api.tmdb.key}")
    public String apiKey;
    public TMDBResponse findTMDBrecommendations(Integer movieId,Integer pageNumber,String lang){
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>("body", headers);

        ResponseEntity<TMDBResponse> response =
                restTemplate.exchange("https://api.themoviedb.org/3/movie/"+movieId+"/recommendations?api_key="+apiKey+
                                "&language="+lang+"&append_to_response=videos,watch/providers&page="+pageNumber,
                        HttpMethod.GET, entity, new ParameterizedTypeReference<TMDBResponse>() {
                        });
        return response.getBody();
    }

    public Object findTMDBDetails(Integer movieId,String lang){
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>("body", headers);

        ResponseEntity<Object> response =
                restTemplate.exchange("https://api.themoviedb.org/3/movie/"+movieId+"?api_key="+apiKey+"&language="+lang+"&append_to_response=videos,watch/providers",
                        HttpMethod.GET, entity, new ParameterizedTypeReference<>() {
                        });
        return response.getBody();
    }

}
