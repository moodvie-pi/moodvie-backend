package br.com.moodvie.form;

import br.com.moodvie.domain.contentList.Types;
import br.com.moodvie.domain.mood.MoodTypes;

public record MoodForm(Long contentId, MoodTypes moodType, Types contentType) {
}
