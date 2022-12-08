package caseModun4.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String notification;

    @ManyToOne
    private NotificationType notificationType;

    @ManyToOne
    private Account account;
}
