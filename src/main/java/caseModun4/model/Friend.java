package caseModun4.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Account account;

    @ManyToOne
    private Account account1;

    @ManyToOne
    private FriendStatus friendStatus;

    public Friend() {
    }

    public Friend(Account account, Account account1, FriendStatus friendStatus) {
        this.account = account;
        this.account1 = account1;
        this.friendStatus = friendStatus;
    }
}
