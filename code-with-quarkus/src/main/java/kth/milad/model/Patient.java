package kth.milad.model;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
//@Table(name = "doctor")
public class Patient extends PanacheEntityBase {
    @Id
    @Column(name = "id")
    private int userId; // Foreign key referencing User table
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    @OneToOne()
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;

    @Override
    public String toString() {
        return "Patient{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                // Exclude printing the associated User
                // "user=" + user +
                '}';
    }

}
