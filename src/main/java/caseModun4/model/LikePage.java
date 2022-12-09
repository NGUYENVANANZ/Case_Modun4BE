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

<<<<<<< HEAD

=======
>>>>>>> 3908d8f32b8ebb4dbad03b670c57301e643ba54f
    @ManyToOne
    private Account accounts;


}
