package uz.agromon.field.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.agromon.field.store.jpo.FieldJpo;

public interface FieldRepository extends JpaRepository<FieldJpo, Integer> {
}
