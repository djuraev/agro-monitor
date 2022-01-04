package uz.agromon.field.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.agromon.field.domain.Field;
import uz.agromon.field.store.jpo.FieldJpo;

import java.util.List;

public interface FieldRepository extends JpaRepository<FieldJpo, Integer> {
    List<FieldJpo> getAllByUsername(String username);
    FieldJpo getByUsernameAndSequence(String username, Integer sequence);
    boolean existsByUsernameAndSequence(String username, Integer sequence);
    List<FieldJpo> getAllByVillageSequence(Integer villageSeq);
}
