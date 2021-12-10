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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer sequence;

    @Column(length = 20)
    private String name;


    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
