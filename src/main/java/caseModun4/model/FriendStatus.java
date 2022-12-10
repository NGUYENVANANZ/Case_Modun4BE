package caseModun4.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class FriendStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String status;

}
