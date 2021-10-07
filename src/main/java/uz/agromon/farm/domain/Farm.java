package uz.agromon.farm.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Farm {
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
