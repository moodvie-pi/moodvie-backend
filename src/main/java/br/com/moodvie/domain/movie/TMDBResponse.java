package br.com.moodvie.domain.movie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TMDBResponse {
    Integer page;
    List<ContentTMDB> results;
    Integer total_pages;
    Integer total_results;
}
