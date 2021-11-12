package uz.agromon.field.store;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uz.agromon.config.exception.klass.ResourceNotFoundException;
import uz.agromon.field.domain.Field;
import uz.agromon.field.store.jpo.FieldJpo;
import uz.agromon.field.store.repo.FieldRepository;

import java.util.Collections;
import java.util.List;

@Repository
public class FieldStoreLogic implements FieldStore {
    @Autowired
    FieldRepository repository;

    @Override
    public Field create(Field field) {
        FieldJpo jpo = new FieldJpo(field);
        return repository.save(jpo).toDomain();
    }

    @Override
    public Field retrieve(Integer sequence) {
        FieldJpo jpo = repository.getById(sequence);
        if (jpo == null) {
            throw new ResourceNotFoundException(Field.class, "Field not found");
        }
        return jpo.toDomain();
    }

    @Override
    public List<Field> retrieve() {
        List<FieldJpo> jpos = repository.findAll();
        return FieldJpo.toDomains(jpos);
    }

    @Override
    public Field update(Field field) {
        FieldJpo jpo = repository.getById(field.getSequence());
        BeanUtils.copyProperties(field, jpo);
        return repository.save(jpo).toDomain();
    }

    @Override
    public void delete(Integer fieldId) {
        FieldJpo jpo = repository.getById(fieldId);
        repository.delete(jpo);
    }

    @Override
    public List<Field> getUserFields(String username) {
        List<FieldJpo> jpos = repository.getAllByUsername(username);
        if (jpos == null || jpos.isEmpty()) {
            return Collections.emptyList();
        }
        return FieldJpo.toDomains(jpos);
    }
}
