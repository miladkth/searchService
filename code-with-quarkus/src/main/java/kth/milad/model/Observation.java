package kth.milad.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
//@Table(name = "observation")
public class Observation extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String msg;
    private LocalDateTime timeStamp;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> conditions;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "encounter")
    private Encounter encounter;
}
