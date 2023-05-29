package br.com.moodvie.mappers;

import br.com.moodvie.domain.movie.ContentDetailsTMDB;
import br.com.moodvie.domain.movie.ContentTMDB;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ContentTMDBMapper {
    ContentTMDB toDefault(ContentDetailsTMDB content);
}
