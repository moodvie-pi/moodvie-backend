package br.com.moodvie.mappers;

import br.com.moodvie.domain.user.User;
import br.com.moodvie.form.UserForm;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    User toEntity(UserForm userForm);
}
