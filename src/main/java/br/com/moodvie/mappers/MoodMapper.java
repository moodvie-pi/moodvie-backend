package br.com.moodvie.mappers;

import br.com.moodvie.domain.mood.Mood;
import br.com.moodvie.dto.MoodDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MoodMapper {
    MoodDTO toDTO(Mood mood);
    Mood toEntity(MoodDTO moodDTO);
}
