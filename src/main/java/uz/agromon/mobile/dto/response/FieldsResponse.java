package uz.agromon.mobile.dto.response;


import uz.agromon.field.domain.Field;

import java.util.List;

public class FieldsResponse extends Response {
    //
    List<Field> fields;

    public FieldsResponse(List<Field> fields) {
        //
        super();
        setResult(true);
        this.fields = fields;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public boolean getResult() {
        return super.getResult();
    }

    public String getMessage() {
        return super.getMessage();
    }

    public String getError_code() {
        return super.getError_code();
    }
}
