package uz.agromon.mobile.dto.response;

import java.util.List;
import java.util.Map;

public class GraphViewResponse extends Response {
    //
    String fieldId;
    String districtId;
    String metricId;
    String metricName;
    Map<String, List<YearValue>> values;

    public GraphViewResponse() {
        //
        setResult(true);
    }

    public GraphViewResponse(String fieldId, String districtId, String metricId, String metricName, Map<String, List<YearValue>> values) {
        //
        this.fieldId = fieldId;
        this.districtId = districtId;
        this.metricId = metricId;
        this.metricName = metricName;
        this.values = values;
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

    public Map<String, List<YearValue>> getValues() {
        return values;
    }

    public void setValues(Map<String, List<YearValue>> values) {
        this.values = values;
    }
}
