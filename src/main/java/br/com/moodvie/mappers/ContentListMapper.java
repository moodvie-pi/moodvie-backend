package br.com.moodvie.mappers;

import br.com.moodvie.domain.contentList.ContentList;
import br.com.moodvie.form.ContentListForm;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ContentListMapper {
    ContentList toEntity(ContentListForm dto);
}
