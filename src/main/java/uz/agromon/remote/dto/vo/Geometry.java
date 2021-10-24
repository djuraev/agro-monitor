package uz.agromon.remote.dto.vo;

import java.util.ArrayList;
import java.util.List;

public class Geometry {
    private String type;
    private List<List<Double[]>> coordinates;

    public Geometry(String type, List<List<Double[]>> coordinates) {
        //
        this.type = type;
        this.coordinates = coordinates;
    }

    public Geometry() {
        //
        this.coordinates = new ArrayList<>();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<List<Double[]>> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<List<Double[]>> coordinates) {
        this.coordinates = coordinates;
    }

}
