package br.com.moodvie.repository;

import br.com.moodvie.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    UserDetails findByUsername(String username);

    @Query("FROM User u WHERE u.username = :username")
    Optional<User> findUserByUsername(String username);

    UserDetails findByEmail(String username);
}
