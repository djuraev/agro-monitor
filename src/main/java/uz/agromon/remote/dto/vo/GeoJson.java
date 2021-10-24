package uz.agromon.remote.dto.vo;

public class GeoJson {
    private String type;
    private Object properties;
    private Geometry geometry;

    public GeoJson(String type, String properties, Geometry geometry) {
        //
        this.type = type;
        this.properties = properties;
        this.geometry = geometry;
    }

    public GeoJson() {
        this.geometry = new Geometry();
        //
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }
}
