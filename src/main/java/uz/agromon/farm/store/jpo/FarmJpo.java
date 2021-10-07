package uz.agromon.farm.store.jpo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "FARM")
public class FarmJpo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tenantId;
    private Integer userId;
    private String polygon;
    private String name;
    private String apiKey;
    private String crop;
    private String center;
    private String comment;
    private String area;

}
