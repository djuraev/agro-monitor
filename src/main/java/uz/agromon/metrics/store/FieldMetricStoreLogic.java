package uz.agromon.metrics.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uz.agromon.config.exception.klass.ResourceNotFoundException;
import uz.agromon.metrics.domain.FieldMetric;
import uz.agromon.metrics.store.jpo.FieldMetricJpo;
import uz.agromon.metrics.store.repo.FieldMetricRepository;

import java.util.List;

@Repository
public class FieldMetricStoreLogic implements FieldMetricStore{

    @Autowired
    FieldMetricRepository repository;

    @Override
    public List<FieldMetric> getMetricsByFieldId(Integer id) {
        List<FieldMetricJpo> jpos = repository.getAllByFieldId(id);
        if (jpos == null) {
            throw new ResourceNotFoundException(FieldMetric.class, "Cannot find field metrics");
        }
        return FieldMetricJpo.toDomains(jpos);
    }

    @Override
    public FieldMetric save(FieldMetric metric) {
        FieldMetricJpo jpo = new FieldMetricJpo(metric);
        return repository.save(jpo).toDomain();
    }
}
