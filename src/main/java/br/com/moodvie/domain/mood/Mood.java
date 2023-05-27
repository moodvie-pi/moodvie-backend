package br.com.moodvie.domain.mood;

import br.com.moodvie.domain.contentList.Types;
import br.com.moodvie.domain.user.User;
import br.com.moodvie.dto.MoodDTO;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "tblmood")
@Entity(name = "Mood")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Mood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "iduser")
    private User user;
    @Column(name = "idmovie")
    private Long idMovie;
    @Enumerated(EnumType.STRING)
    @Column(name = "moodtype")
    private MoodTypes moodType;
    @Enumerated(EnumType.STRING)
    @Column(name = "contenttype")
    private Types contentType;

    public static Mood convert(MoodDTO moodDTO, User user){
        return Mood.builder()
                .user(user)
                .idMovie(moodDTO.idMovie())
                .moodType(moodDTO.moodType())
                .contentType(moodDTO.contentType())
                .build();
    }
}
