package kth.milad.model;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Builder
public class Doctor extends PanacheEntityBase {
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
        return "Doctor{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                // Exclude printing the associated User
                // "user=" + user +
                '}';
    }

}
