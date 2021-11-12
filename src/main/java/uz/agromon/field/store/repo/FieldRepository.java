package uz.agromon.field.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.agromon.field.domain.Field;
import uz.agromon.field.store.jpo.FieldJpo;

import java.util.List;

public interface FieldRepository extends JpaRepository<FieldJpo, Integer> {
    List<FieldJpo> getAllByUsername(String username);
    FieldJpo getByUsername(String username);
}
