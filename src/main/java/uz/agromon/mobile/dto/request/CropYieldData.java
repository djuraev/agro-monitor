package uz.agromon.mobile.dto.request;

public class CropYieldData {
    //
    public String year;
    public String value;

    public CropYieldData() {
        //
    }

    public CropYieldData(String year, String value) {
        //
        this.year = year;
        this.value = value;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
