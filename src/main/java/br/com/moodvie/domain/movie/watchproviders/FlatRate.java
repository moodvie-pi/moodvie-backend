package br.com.moodvie.domain.movie.watchproviders;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FlatRate{
    String logo_path;
    Integer provider_id;
    String provider_name;
    Integer display_priority;
}
