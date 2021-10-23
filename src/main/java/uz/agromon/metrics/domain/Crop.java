package uz.agromon.metrics.domain;

public class Crop {
    //
    private String name;
    private String extraInfo;
    private String code;

    public Crop(String name, String extraInfo, String code) {
        //

        this.name = name;
        this.extraInfo = extraInfo;
        this.code = code;
    }

    public Crop() {
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
