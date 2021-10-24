package uz.agromon.remote.dto;

import uz.agromon.remote.dto.vo.GeoJson;

import java.util.List;

public class AgromonResponse {
    //
    private String id;
    private GeoJson geo_json;
    private String name;
    private List<Double> center;
    private Double area;
    private String user_id;

    public AgromonResponse(String id, GeoJson geo_json, String name, List<Double> center, Double area, String user_id) {
        this.id = id;
        this.geo_json = geo_json;
        this.name = name;
        this.center = center;
        this.area = area;
        this.user_id = user_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public GeoJson getGeo_json() {
        return geo_json;
    }

    public void setGeo_json(GeoJson geo_json) {
        this.geo_json = geo_json;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Double> getCenter() {
        return center;
    }

    public void setCenter(List<Double> center) {
        this.center = center;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
