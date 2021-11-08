package uz.agromon.tenant.store.jpo;

import org.springframework.beans.BeanUtils;
import uz.agromon.tenant.domain.ApiInfo;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name="API_INFO")
public class ApiInfoJpo {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    Integer sequence;
    private String apiName;
    private String apiKey;
    private boolean isExpired;

    public ApiInfoJpo(ApiInfo apiInfo) {
        //
        BeanUtils.copyProperties(apiInfo, this);
    }

    public ApiInfoJpo() {
        //
    }

    public ApiInfo toDomain() {
        ApiInfo apiInfo = new ApiInfo();
        BeanUtils.copyProperties(this, apiInfo);
        return apiInfo;
    }

    public static List<ApiInfo> toDomains(List<ApiInfoJpo> jpos) {
        return jpos.stream().map(ApiInfoJpo::toDomain).collect(Collectors.toList());
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public boolean isExpired() {
        return isExpired;
    }

    public void setExpired(boolean expired) {
        isExpired = expired;
    }
}
