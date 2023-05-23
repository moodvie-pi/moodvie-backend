package br.com.moodvie.domain.usersList;

import br.com.moodvie.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "tbluserslist")
@Entity(name = "UsersList")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsersList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="idUser")
    private User idUser;
    private Long idMovie;
    private String listName;
}
