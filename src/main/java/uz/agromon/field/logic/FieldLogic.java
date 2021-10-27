package uz.agromon.field.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.agromon.field.domain.Field;
import uz.agromon.field.service.FieldService;
import uz.agromon.field.store.FieldStore;
import uz.agromon.field.store.jpo.FieldJpo;
import uz.agromon.remote.AgroMonitoringCaller;

import java.util.List;

@Service
public class FieldLogic implements FieldService {
    @Autowired
    FieldStore fieldStore;

    @Autowired
    AgroMonitoringCaller agroMonitoringCaller;

    @Override
    public Field create(Field field) {
        field = agroMonitoringCaller.createField(field);
        return fieldStore.create(field);
    }

    @Override
    public Field update(Field field) {
        return fieldStore.update(field);
    }

    @Override
    public Field getField(Integer sequence) {
        return fieldStore.retrieve(sequence);
    }

    @Override
    public List<Field> getFieldOfVillage(Integer villageSequence) {
        return null;
    }

    @Override
    public List<Field> getFieldOfDistrict(Integer districtSequence) {
        return null;
    }

    @Override
    public void deleteField(Integer fieldId) {
        Field field = fieldStore.retrieve(fieldId);
        agroMonitoringCaller.deleteField(field.getApiKey());
        fieldStore.delete(fieldId);
    }
}
