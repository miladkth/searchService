package kth.milad.model;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import io.smallrye.mutiny.Uni;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

import static io.quarkus.hibernate.reactive.panache.PanacheEntityBase.find;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
//@Table(name = "encounter")
public class Encounter extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int userId;
    private LocalDateTime timeStamp;

    @OneToMany(mappedBy = "encounter", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Observation> observations;

    public static Uni<List<PanacheEntityBase>> findByUserId(int userId) {
        return find("user.id", userId).list();
    }

    public static Uni<PanacheEntityBase> findById(int id) {
        return find("id", id).firstResult();
    }
}
