package br.com.moodvie.domain.contentList;

import br.com.moodvie.domain.user.User;
import br.com.moodvie.dto.ContentListDTO;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "tblcontentlist")
@Entity(name = "ContentList")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContentList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "iduser")
    private User user;
    @Column(name = "idcontent")
    private Long contentId;
    @Enumerated(EnumType.STRING)
    @Column(name = "listtype")
    private ContentListTypes listType;
    @Column(name = "listname")
    private String listName;
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private Types type;
}

