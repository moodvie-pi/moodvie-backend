package br.com.moodvie.domain.movie;

import br.com.moodvie.domain.movie.watchproviders.WatchProviders;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class ContentDetailsTMDB {
    Boolean adult;
    String backdrop_path;
    Integer id;
    String title;
    String name;
    String original_language;
    String original_title;
    String original_name;
    String overview;
    String poster_path;
    String media_type;
    List<GenreTMDB> genres;
    Double popularity;
    Date release_date;
    Date first_air_date;
    Boolean video;
    Double vote_average;
    Double vote_count;
    String imdb_id;

    Integer runtime;

    String tagline;

    String status;

    @JsonProperty("watch/providers")
    WatchProviders watchProviders;
}

//{
//        "imdb_id": "tt0137523",
//        "revenue": 100853753,
//        "runtime": 139,
//        "spoken_languages": [
//        {
//        "english_name": "English",
//        "iso_639_1": "en",
//        "name": "English"
//        }
//        ],
//        "status": "Released",
//        "tagline": "Má conduta. Caos. Sabão.",
//        "videos": {
//        "results": [
//        {
//        "iso_639_1": "pt",
//        "iso_3166_1": "BR",
//        "name": "Clube da Luta | 1999 | Trailer Legendado | Fight Club",
//        "key": "eBKvlCf0B4g",
//        "published_at": "2011-07-21T04:17:03.000Z",
//        "site": "YouTube",
//        "size": 480,
//        "type": "Trailer",
//        "official": false,
//        "id": "57e6bf38925141414600bbe1"
//        }
//        ]
//        }
//        }