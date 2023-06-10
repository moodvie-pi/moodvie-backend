package br.com.moodvie.mappers;

import br.com.moodvie.domain.contentList.Types;
import org.hibernate.query.sqm.sql.ConversionException;

public class TypeMapper {
    public Types toTypes(String type){
        if(type.trim().equalsIgnoreCase("MOVIE"))
            return Types.MOVIE;
        else if(type.trim().equalsIgnoreCase("TV"))
            return Types.TV_SHOW;
        else
            throw new ConversionException("falha ao converter tipo de conteúdo.");
    }
}
