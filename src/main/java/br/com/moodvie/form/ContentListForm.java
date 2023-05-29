package br.com.moodvie.form;

import br.com.moodvie.domain.contentList.ContentListTypes;
import br.com.moodvie.domain.contentList.Types;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ContentListForm {

    @NotNull
    Long contentId;
    @NotNull
    ContentListTypes listType;
    String listName;
    @NotNull
    Types type;
}
