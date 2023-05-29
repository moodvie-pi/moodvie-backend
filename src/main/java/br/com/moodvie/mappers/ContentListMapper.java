package br.com.moodvie.mappers;

import br.com.moodvie.domain.contentList.ContentList;
import br.com.moodvie.dto.ContentListDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import javax.swing.text.html.parser.Entity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ContentListMapper {
    ContentList toEntity(ContentListDTO dto);
}
