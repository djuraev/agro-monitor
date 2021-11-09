package uz.agromon.mobile.dto.request;

public class GraphViewRequest {
    //
    String field_id;
    String sequence;

    public GraphViewRequest(String field_id, String sequence) {
        //
        this.field_id = field_id;
        this.sequence = sequence;
    }

    public GraphViewRequest() {
        //
    }

    public String getField_id() {
        return field_id;
    }

    public void setField_id(String field_id) {
        this.field_id = field_id;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }
}
