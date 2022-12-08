package caseModun4.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;
    private String password;
    private String phoneNumber;
    private String fullName;
    private LocalDate birthday;
    private String address;
    private String gender;
    private String img;
    private boolean status;

    @ManyToOne(fetch = FetchType.EAGER)
    private Role roles;



}
