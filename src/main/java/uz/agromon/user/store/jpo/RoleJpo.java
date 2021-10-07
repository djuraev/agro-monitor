package uz.agromon.user.store.jpo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.agromon.user.domain.ERole;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ROLES")
public class RoleJpo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sequence;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;
}
