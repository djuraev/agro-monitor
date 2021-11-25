package uz.agromon.mobile.dto.response;

import uz.agromon.metrics.domain.Metric;

import java.util.List;

public class MetricsResponse extends Response {
    List<Metric> list;

    public MetricsResponse() {
        //
        setResult(true);
    }

    public MetricsResponse(List<Metric> list) {
        //
        this.list = list;
    }

    public List<Metric> getList() {
        return list;
    }

    public void setList(List<Metric> list) {
        this.list = list;
    }
}
