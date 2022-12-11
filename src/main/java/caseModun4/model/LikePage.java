package caseModun4.model;

import lombok.Data;
import javax.persistence.*;
import java.util.List;
@Entity
@Data
public class LikePage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Account accounts;


}
