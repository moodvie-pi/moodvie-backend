package br.com.moodvie.services;

import br.com.moodvie.domain.mood.Mood;
import br.com.moodvie.domain.user.User;
import br.com.moodvie.dto.MoodDTO;
import br.com.moodvie.mappers.MoodMapper;
import br.com.moodvie.repository.MoodRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MoodService {
    private final MoodRepository moodRepository;
    private final UserService userService;
    private final MoodMapper moodMapper;

    public void create(MoodDTO moodDTO){
        User user = userService.findLoggedUser();
        Mood mood = moodMapper.toEntity(moodDTO);
        mood.setUser(user);
        this.moodRepository.save(mood);
    }

    public void updateMood(MoodDTO moodDTO){
        User user = userService.findLoggedUser();
        Mood newMood = moodMapper.toEntity(moodDTO);
        newMood.setUser(user);

        moodRepository.findByTypeUserMood(newMood.getContentType(),newMood.getUser(),newMood.getMoodType()).ifPresentOrElse((oldMood)-> {
            oldMood.setContentId(newMood.getContentId());
            moodRepository.save(oldMood);
        },()-> moodRepository.save(newMood));
    }
}
