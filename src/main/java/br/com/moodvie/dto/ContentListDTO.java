package br.com.moodvie.dto;

import br.com.moodvie.domain.contentList.ContentListTypes;
import br.com.moodvie.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ContentListDTO {

    @NotNull
    Long movieId;
    @NotNull
    ContentListTypes listType;
    String listName;

}
