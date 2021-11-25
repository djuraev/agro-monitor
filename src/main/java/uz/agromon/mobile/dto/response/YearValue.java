package uz.agromon.mobile.dto.response;

public class YearValue {
    //
    String year;
    String value;

    public YearValue(String year, String value) {
        //
        this.year = year;
        this.value = value;
    }

    public YearValue() {
        //
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
