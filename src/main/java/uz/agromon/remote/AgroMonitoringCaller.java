package uz.agromon.remote;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.agromon.config.exception.klass.RemoteRefusedException;
import uz.agromon.field.domain.Field;
import uz.agromon.remote.dto.AgromonResponse;
import uz.agromon.remote.dto.RequestBody;

@Service
public class AgroMonitoringCaller {
    //
    @Value("${agromonitoring.api-url}")
    private String apiURL;
    @Value("${agromonitoring.api-key}")
    private String apiKey;

    @Autowired
    RestTemplate restTemplate;

    public Field createField(Field field) {
        RequestBody requestBody = new RequestBody(field);
        String url = apiURL.concat("?appid=").concat(this.apiKey);

        AgromonResponse response = restTemplate.postForObject(url, requestBody, AgromonResponse.class);
        if (response == null) {
            throw new RemoteRefusedException("Agromonitoring API call error. ");
        }
        field.setApiKey(response.getId());
        field.setCenter(response.getCenter().toString());
        field.setAgromonArea(response.getArea().toString());

        Field entity = new Field();
        BeanUtils.copyProperties(field, entity);
        return entity;
    }

    public void deleteField(String fieldApiKey) {
        String url = apiURL
                .concat("/")
                .concat(fieldApiKey).concat("?appid=").concat(this.apiKey);
        try {
           restTemplate.delete(url);
        }
        catch (Exception e) {
            throw e;
        }
    }
}
