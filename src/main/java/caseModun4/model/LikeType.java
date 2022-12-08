package caseModun4.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class LikeType {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        private String likeType;


}
