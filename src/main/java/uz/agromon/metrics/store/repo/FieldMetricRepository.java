package uz.agromon.metrics.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.agromon.field.store.jpo.FieldJpo;
import uz.agromon.metrics.store.jpo.FieldMetricJpo;

import java.util.List;

@Deprecated
public interface FieldMetricRepository extends JpaRepository<FieldMetricJpo, Integer> {
    List<FieldMetricJpo> getAllByFieldId(Integer id);
}
