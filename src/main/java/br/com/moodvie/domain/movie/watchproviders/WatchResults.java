package br.com.moodvie.domain.movie.watchproviders;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WatchResults{
    @JsonProperty("BR")
    CountryResult br;
    @JsonProperty("US")
    CountryResult us;
}