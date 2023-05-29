package br.com.moodvie.dto;

import br.com.moodvie.domain.contentList.Types;
import br.com.moodvie.domain.mood.MoodTypes;
import br.com.moodvie.domain.movie.ContentTMDB;

public record MoodDTO(ContentTMDB content, MoodTypes moodType, Types contentType) {
}
