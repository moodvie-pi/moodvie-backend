package br.com.moodvie.services;

import br.com.moodvie.domain.contentList.Types;
import br.com.moodvie.domain.mood.Mood;
import br.com.moodvie.domain.movie.ContentTMDB;
import br.com.moodvie.domain.user.User;
import br.com.moodvie.dto.MoodDTO;
import br.com.moodvie.form.MoodForm;
import br.com.moodvie.mappers.ContentTMDBMapper;
import br.com.moodvie.mappers.MoodMapper;
import br.com.moodvie.repository.MoodRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class MoodService {
    private final MoodRepository moodRepository;
    private final TMDBService tmdbService;
    private final UserService userService;
    private final MoodMapper moodMapper;
    private final ContentTMDBMapper contentMapper;

    public void create(MoodForm moodForm){
        User user = userService.findLoggedUser();

        Mood mood = moodMapper.toEntity(moodForm);
        mood.setUser(user);

        this.moodRepository.save(mood);
    }

    public void updateMood(MoodForm moodForm){
        User user = userService.findLoggedUser();

        Mood newMood = moodMapper.toEntity(moodForm);
        newMood.setUser(user);

        moodRepository.findByTypeUserMood(newMood.getContentType(),newMood.getUser(),newMood.getMoodType()).ifPresentOrElse((oldMood)-> {
            oldMood.setContentId(newMood.getContentId());
            moodRepository.save(oldMood);
        },()-> moodRepository.save(newMood));
    }

    public List<MoodDTO> findMoods(String lang){
        User user = userService.findLoggedUser();

        return moodRepository.findByUser(user).stream().map((mood)->{
            String type = mood.getContentType() == Types.MOVIE? "movie":"tv";
            ContentTMDB content = contentMapper.toDefault(tmdbService.getMovieDetails(type,mood.getContentId(),lang));
            return new MoodDTO(content, mood.getMoodType(),mood.getContentType());
        }).toList();
    }
}
