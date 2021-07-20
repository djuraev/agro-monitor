package uz.agromon.field.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uz.agromon.field.domain.Field;
import uz.agromon.field.store.jpo.FieldJpo;
import uz.agromon.field.store.repo.FieldRepository;

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
        return jpo.toDomain();
    }

    @Override
    public List<Field> retrieve() {
        List<FieldJpo> jpos = repository.findAll();
        return FieldJpo.toDomains(jpos);
    }
}
