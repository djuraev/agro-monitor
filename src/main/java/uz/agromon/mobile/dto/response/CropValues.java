package uz.agromon.mobile.dto.response;

import java.util.ArrayList;
import java.util.List;

public class CropValues {
    //
    String cropName;
    String name;
    List<YearValue> chartInfoList;

    public CropValues() {
        //
        chartInfoList = new ArrayList<>();
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public List<YearValue> getChartInfoList() {
        return chartInfoList;
    }

    public void setChartInfoList(List<YearValue> chartInfoList) {
        this.chartInfoList = chartInfoList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
