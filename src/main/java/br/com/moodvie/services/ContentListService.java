package br.com.moodvie.services;

import br.com.moodvie.domain.contentList.ContentList;
import br.com.moodvie.domain.contentList.ContentListTypes;
import br.com.moodvie.domain.user.User;
import br.com.moodvie.dto.ContentListDTO;
import br.com.moodvie.repository.ContentListRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ContentListService {

    private final ContentListRepository contentListRepository;

    public void create(User user, ContentListDTO contentListDTO) {
        ContentList contentList = new ContentList();
        contentList = contentList.convert(contentListDTO);
        contentList.setUser(user);
        contentListRepository.save(contentList);
    }
}
