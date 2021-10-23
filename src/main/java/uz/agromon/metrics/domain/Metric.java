package uz.agromon.metrics.domain;

public class Metric {
    //
    private Integer sequence;
    private String name;
    private String extraInfo;
    private String code;

    public Metric(Integer sequence, String name, String extraInfo, String code) {
        this.sequence = sequence;
        this.name = name;
        this.extraInfo = extraInfo;
        this.code = code;
    }

    public Metric() {
    }

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

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
