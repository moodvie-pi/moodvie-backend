package br.com.moodvie.dto;

import br.com.moodvie.domain.contentList.Types;
import br.com.moodvie.domain.mood.MoodTypes;

public record MoodDTO(Long idMovie, MoodTypes moodType, Types contentType) {
}
