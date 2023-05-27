package br.com.moodvie.repository;

import br.com.moodvie.domain.contentList.Types;
import br.com.moodvie.domain.mood.Mood;
import br.com.moodvie.domain.mood.MoodTypes;
import br.com.moodvie.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MoodRepository extends JpaRepository<Mood, Long> {
    @Query("FROM Mood m WHERE m.contentType = :type AND m.user = :user AND m.moodType = :mood")
    Optional<Mood> findByTypeUserMood(Types type, User user, MoodTypes mood);
}
