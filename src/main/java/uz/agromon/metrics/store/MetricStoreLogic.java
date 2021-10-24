package uz.agromon.metrics.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uz.agromon.metrics.domain.Metric;
import uz.agromon.metrics.store.jpo.MetricJpo;
import uz.agromon.metrics.store.repo.MetricRepository;

import java.util.List;

@Repository
public class MetricStoreLogic implements MetricStore {

    @Autowired
    MetricRepository repository;

    @Override
    public Metric save(Metric metric) {
        MetricJpo jpo = new MetricJpo(metric);
        return repository.save(jpo).toDomain();
    }

    @Override
    public Metric getById(Integer id) {
        return repository.getById(id).toDomain();
    }

    @Override
    public List<Metric> getAllMetrics() {
        return MetricJpo.toDomains(repository.getAllBy());
    }
}
