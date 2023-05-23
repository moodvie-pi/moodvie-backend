package br.com.moodvie.domain.movie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SimplifiedContentTMDB {
    Boolean adult;
    String backdrop_path;
    Integer id;
    String title;
    String name;
    Date release_date;
    Date first_air_date;
}
