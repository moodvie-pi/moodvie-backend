package br.com.moodvie.services;

import br.com.moodvie.domain.mood.Mood;
import br.com.moodvie.domain.user.User;
import br.com.moodvie.dto.MoodDTO;
import br.com.moodvie.repository.MoodRepository;
import br.com.moodvie.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@AllArgsConstructor
@Service
public class MoodService {
    private final MoodRepository moodRepository;
    private final UserRepository userRepository;
    private final UserService userService;

    public void create(MoodDTO moodDTO){
        User user = this.userService.findLoggedUser();
        Mood mood = Mood.convert(moodDTO,user);
        this.moodRepository.save(mood);
    }

    public void updateMood(MoodDTO moodDTO){
        User user = this.userService.findLoggedUser();
        Mood newMood = Mood.convert(moodDTO,user);
        this.moodRepository.findByTypeUserMood(newMood.getContentType(),newMood.getUser(),newMood.getMoodType()).ifPresentOrElse((oldMood)-> {
            oldMood.setIdMovie(newMood.getIdMovie());
            this.moodRepository.save(oldMood);
        },()->{
            this.moodRepository.save(newMood);
        });
    }
}
