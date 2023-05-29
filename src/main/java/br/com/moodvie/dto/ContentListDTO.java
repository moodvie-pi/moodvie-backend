package br.com.moodvie.dto;

import br.com.moodvie.domain.contentList.ContentListTypes;
import br.com.moodvie.domain.contentList.Types;

public record ContentListDTO(Long contentId, ContentListTypes listType, String listName, Types type) {
}
