package br.com.moodvie.repository;

import br.com.moodvie.domain.contentList.ContentList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentListRepository extends JpaRepository<ContentList, Long> {
}
