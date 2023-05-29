package br.com.moodvie.services;

import br.com.moodvie.domain.contentList.ContentList;
import br.com.moodvie.domain.user.User;
import br.com.moodvie.form.ContentListForm;
import br.com.moodvie.mappers.ContentListMapper;
import br.com.moodvie.repository.ContentListRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ContentListService {

    private final ContentListRepository contentListRepository;
    private final UserService userService;
    private final ContentListMapper contentListMapper;

    public void create( ContentListForm contentListForm) {
        User user = userService.findLoggedUser();
        ContentList contentList = contentListMapper.toEntity(contentListForm);
        contentList.setUser(user);
        contentListRepository.save(contentList);
    }
}
