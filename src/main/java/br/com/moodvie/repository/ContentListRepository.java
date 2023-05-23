package br.com.moodvie.repository;

import br.com.moodvie.domain.contentList.ContentList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentListRepository extends JpaRepository<ContentList, Long> {
}
