package uz.agromon.mobile.dto.response;

import java.util.ArrayList;
import java.util.List;

public class GraphViewResponse extends Response {
    //
    String fieldId;
    String districtId;
    String metricId;
    String metricName;
    List<CropValues> values;

    public GraphViewResponse() {
        //
        values = new ArrayList<>();
        setResult(true);
    }

    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public String getMetricId() {
        return metricId;
    }

    public void setMetricId(String metricId) {
        this.metricId = metricId;
    }

    public String getMetricName() {
        return metricName;
    }

    public void setMetricName(String metricName) {
        this.metricName = metricName;
    }

    public List<CropValues> getValues() {
        return values;
    }

    public void setValues(List<CropValues> values) {
        this.values = values;
    }
}
