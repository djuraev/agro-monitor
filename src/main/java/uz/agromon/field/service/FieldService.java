package uz.agromon.field.service;

import uz.agromon.field.domain.Field;

import java.util.List;

public interface FieldService {
    Field create(Field field);
    Field update(Field field);
    Field getField(Integer sequence);
    List<Field> getFieldOfVillage(Integer villageSequence);
    List<Field> getFieldOfDistrict(Integer districtSequence);
    List<Field> getFieldsOfUser(String username);
    void deleteField(Integer fieldId);
    boolean isUserFieldOwner(String username, Integer fieldId);
}
