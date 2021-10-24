package uz.agromon.metrics.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uz.agromon.metrics.domain.DistrictMetric;
import uz.agromon.metrics.store.jpo.DistrictMetricJpo;
import uz.agromon.metrics.store.repo.DistrictMetricRepository;

import java.util.List;


@Repository
public class DistrictMetricStoreLogic implements DistrictMetricStore {

    @Autowired
    DistrictMetricRepository repository;


    @Override
    public DistrictMetric save(DistrictMetric metric) {
        DistrictMetricJpo jpo = new DistrictMetricJpo(metric);
        return repository.save(jpo).toDomain();
    }

    @Override
    public DistrictMetric getById(Integer id) {
        return repository.getById(id).toDomain();
    }

    @Override
    public List<DistrictMetric> retrieveAll() {
        return DistrictMetricJpo.toDomains(repository.getAllBy());
    }
}
