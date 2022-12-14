package caseModun4.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Cmt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String text;

    @ManyToOne
    private Account accounts;

    @ManyToMany
    private List<LikeCmt> likeCmts;

    public Cmt() {
    }

    public Cmt(String text, Account accounts, List<LikeCmt> likeCmts) {
        this.text = text;
        this.accounts = accounts;
        this.likeCmts = likeCmts;
    }
}
