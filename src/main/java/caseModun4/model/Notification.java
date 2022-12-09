package caseModun4.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Account account1;

    @ManyToOne
    private Page page;

    @ManyToOne
    private NotificationType notificationType;

    @ManyToOne
    private Account account;
}
