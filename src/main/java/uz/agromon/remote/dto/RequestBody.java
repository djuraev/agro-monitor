package uz.agromon.remote.dto;

import uz.agromon.field.domain.Field;
import uz.agromon.remote.dto.vo.GeoJson;

import java.util.ArrayList;
import java.util.List;

public class RequestBody {
    private String name;
    private GeoJson geo_json;

    public RequestBody(String name, GeoJson geo_json) {
        //
        this.name = name;
        this.geo_json = geo_json;
    }

    public RequestBody(Field field) {
        this.name = field.getName();
        this.geo_json = new GeoJson();
        this.geo_json.setType("Feature");

        List<Double[]> coordinates = new ArrayList<>();
        String[] splits = field.getPolygon().trim().split(":");

        for (String split: splits) {
            String[] xyC = split.split("\\+");
            Double[] xy = new Double[]{Double.parseDouble(xyC[0]), Double.parseDouble(xyC[1])};
            coordinates.add(xy);
        }
        List<List<Double[]>> coordinateList = new ArrayList<>();
        coordinateList.add(coordinates);
        this.geo_json.getGeometry().setCoordinates(coordinateList);
        this.geo_json.getGeometry().setType("Polygon");
    }

    public RequestBody() {
        //
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GeoJson getGeo_json() {
        return geo_json;
    }

    public void setGeo_json(GeoJson geo_json) {
        this.geo_json = geo_json;
    }
}
