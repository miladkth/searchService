package kth.milad.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import io.smallrye.mutiny.Uni;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collections;
import java.util.List;

import static io.quarkus.hibernate.reactive.panache.PanacheEntityBase.find;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class User extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int userId; // Unique identifier shared across all users

    // Relationships with other entities
    @JsonIgnore
    @OneToOne(mappedBy = "user", cascade=CascadeType.ALL)
    private Doctor doctor;

    @JsonIgnore
    @OneToOne(mappedBy = "user", cascade=CascadeType.ALL)
    private Others others;

    @JsonIgnore
    @OneToOne(mappedBy = "user", cascade=CascadeType.ALL)
    private Patient patient;

    /*public static Uni<List<PanacheEntityBase>> findByName(String name) {
        return find("name", name).list();
    }*/

    public static Uni<java.util.List<PanacheEntityBase>> findByDoctorName(String name1) {
        return find("name = ?1 and role = ?2", name1, Role.DOCTOR).list();
    }

    public static Uni<List<User>> findByName(String name1) {
        return find("name", name1).list();
    }

/*

    public static Uni<List<User>> findByDoctorAndEncounter(String name) {
        return find("firstname = ?1 and role = ?2", name, Role.DOCTOR)
                .firstResult()
                .onItem().ifNotNull().transform(user -> {
                    // Ditt befintliga logik för att hämta användare baserat på doktorns id och möten
                    return user;
                })
                .onItem().ifNull().continueWith();
    }
    public Uni<Integer> getId() {
        return User.find("name", this.name).firstResult().onItem().ifNotNull().transform(User::getUserId).onItem().ifNull().continueWith(-1);
    }

 */
}
