package br.com.moodvie.domain.movie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovieTMDB {
       Boolean adult;
       String backdrop_path;
       Integer id;
       String title;
       String original_language;
       String original_title;
       String overview;
       String poster_path;
       String media_type;
       List<Integer> genre_ids;
       Double popularity;
       Date release_date;
       Boolean video;
       Double vote_average;
       Double vote_count;
}
