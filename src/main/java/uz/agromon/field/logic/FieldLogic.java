package uz.agromon.field.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.agromon.config.exception.klass.ResourceNotFoundException;
import uz.agromon.field.domain.Field;
import uz.agromon.field.service.FieldService;
import uz.agromon.field.store.FieldStore;
import uz.agromon.remote.AgroMonitoringCaller;
import uz.agromon.user.domain.User;
import uz.agromon.user.service.UserService;

import java.util.List;

@Service
public class FieldLogic implements FieldService {
    @Autowired
    FieldStore fieldStore;
    @Autowired
    UserService userService;
    @Autowired
    AgroMonitoringCaller agroMonitoringCaller;

    @Override
    public Field create(Field field) {
        boolean userExists = userService.userExists(field.getUsername());
        if (!userExists) {
            throw new ResourceNotFoundException(User.class, "Username not found: "+field.getUsername());
        }
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
    public List<Field> getFieldsOfUser(String username) {
        return fieldStore.getUserFields(username);
    }

    @Override
    public void deleteField(Integer fieldId) {
        Field field = fieldStore.retrieve(fieldId);
        agroMonitoringCaller.deleteField(field.getApiKey());
        fieldStore.delete(fieldId);
    }

    @Override
    public boolean isUserFieldOwner(String username, Integer fieldId) {
        return false;
    }
}
