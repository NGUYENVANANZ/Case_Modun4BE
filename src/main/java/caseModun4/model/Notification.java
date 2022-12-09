package caseModun4.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long id_account;

    private long id_page;

    @ManyToOne
    private NotificationType notificationType;

    @ManyToOne
    private Account account;
}
