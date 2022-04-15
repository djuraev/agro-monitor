package uz.agromon.field.store;

import  org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import uz.agromon.config.exception.klass.ResourceNotFoundException;
import uz.agromon.field.domain.Field;
import uz.agromon.field.store.jpo.FieldJpo;
import uz.agromon.field.store.repo.FieldRepository;
import uz.agromon.user.store.jpo.UserJpo;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
        Optional<FieldJpo> jpo = repository.findById(sequence);
        if (jpo.isPresent()) {
            return jpo.get().toDomain();
        }
        throw new ResourceNotFoundException(Field.class, "Field not found");
    }

    @Override
    public List<Field> retrieve() {
        List<FieldJpo> jpos = repository.findAll();
        return FieldJpo.toDomains(jpos);
    }

    @Override
    public Field update(Field field) {
        FieldJpo jpo = repository.getById(field.getFieldId());
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

    @Override
    public Field getByUsernameAndId(String username, Integer id) {
        return repository.getByUsernameAndSequence(username, id).toDomain();
    }

    @Override
    public boolean existsByUsernameAndId(String username, Integer fieldId) {
        return repository.existsByUsernameAndSequence(username, fieldId);
    }

    @Override
    public List<Field> getVillageFields(Integer vid) {
        List<FieldJpo> fieldJpos = repository.getAllByVillageSequence(vid);
        return FieldJpo.toDomains(fieldJpos);
    }

    @Override
    public List<FieldJpo> findAll(Field field) {
        FieldJpo fieldJpo = new FieldJpo(field);
        Example<FieldJpo> example = Example.of(fieldJpo);
        return repository.findAll(example);
    }
}

