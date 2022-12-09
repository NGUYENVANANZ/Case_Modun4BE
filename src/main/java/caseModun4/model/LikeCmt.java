package caseModun4.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class LikeCmt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Account accounts;


}
