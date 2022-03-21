package uz.agromon.field.store;

import uz.agromon.field.domain.Field;
import uz.agromon.field.store.jpo.FieldJpo;

import java.util.List;

public interface FieldStore {
    Field create(Field field);
    Field retrieve(Integer sequence);
    List<Field> retrieve();
    Field update(Field field);
    void delete(Integer field);
    List<Field> getUserFields(String username);
    Field getByUsernameAndId(String username, Integer id);
    boolean existsByUsernameAndId(String username, Integer fieldId);
    List<Field> getVillageFields(Integer vid);
    List<FieldJpo> findAll(Field field);
}
