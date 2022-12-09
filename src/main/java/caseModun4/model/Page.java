package caseModun4.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Page {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDateTime time;
    private String text;
    private String img;

    @ManyToOne
    private Account account;

    @OneToMany
    private List<Cmt> cmts;

    @OneToMany
    private List<LikePage> likePages;
}
