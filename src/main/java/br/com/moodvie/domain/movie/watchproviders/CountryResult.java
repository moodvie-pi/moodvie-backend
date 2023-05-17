package br.com.moodvie.domain.movie.watchproviders;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CountryResult{
    String link;
    List<FlatRate> flatrate;
}