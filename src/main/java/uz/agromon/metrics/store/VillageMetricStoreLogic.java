package uz.agromon.metrics.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uz.agromon.metrics.domain.VillageMetric;
import uz.agromon.metrics.store.jpo.VillageMetricJpo;
import uz.agromon.metrics.store.repo.VillageMetricRepository;

import java.util.List;

@Repository
public class VillageMetricStoreLogic implements VillageMetricStore {

    @Autowired
    VillageMetricRepository repository;

    @Override
    public VillageMetric save(VillageMetric metric) {
        return repository.save(new VillageMetricJpo(metric)).toDomain();
    }

    @Override
    public VillageMetric getById(Integer id) {
        return repository.getById(id).toDomain();
    }

    @Override
    public List<VillageMetric> getAll() {
        return VillageMetricJpo.toDomains(repository.getAllBy());
    }
}
