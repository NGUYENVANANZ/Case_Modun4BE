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

    public Notification(Account account,Account account1 , NotificationType notificationType) {
        this.account1 = account1;
        this.notificationType = notificationType;
        this.account = account;
    }

    public Notification(Account account, Account account1, Page page, NotificationType notificationType) {
        this.account1 = account1;
        this.page = page;
        this.notificationType = notificationType;
        this.account = account;
    }

    public Notification() {

    }
}
