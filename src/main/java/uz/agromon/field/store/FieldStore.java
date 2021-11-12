package uz.agromon.field.store;

import uz.agromon.field.domain.Field;

import java.util.List;

public interface FieldStore {
    Field create(Field field);
    Field retrieve(Integer sequence);
    List<Field> retrieve();
    Field update(Field field);
    void delete(Integer field);
    List<Field> getUserFields(String username);
}
