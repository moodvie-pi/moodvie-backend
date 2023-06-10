package br.com.moodvie.form;

import br.com.moodvie.domain.user.UserRoles;

import java.time.LocalDate;

public record UserForm(Long id, String username, String password, UserRoles role, String email, String name, LocalDate birthdate) {
}
