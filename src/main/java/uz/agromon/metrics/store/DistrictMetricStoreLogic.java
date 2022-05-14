package uz.agromon.metrics.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;
import uz.agromon.config.exception.klass.AlreadyExistsException;
import uz.agromon.metrics.domain.DistrictMetric;
import uz.agromon.metrics.store.jpo.DistrictMetricJpo;
import uz.agromon.metrics.store.repo.DistrictMetricRepository;
import uz.agromon.tenant.domain.District;
import uz.agromon.tenant.store.DistrictStore;
import uz.agromon.tenant.store.jpo.DistrictJpo;
import uz.agromon.tenant.store.repo.DistrictRepository;


import java.util.List;


@Repository
public class DistrictMetricStoreLogic implements DistrictMetricStore {

    @Autowired
    DistrictMetricRepository repository;

    @Autowired
    DistrictRepository districtRepository;

    @Override
    public DistrictMetric save(DistrictMetric metric) throws AlreadyExistsException {
        DistrictJpo districtJpo = districtRepository.getById(metric.getDistrictId());
        metric.setTenantId(districtJpo.getTenantId());
        DistrictMetricJpo jpo = new DistrictMetricJpo(metric);

        List<DistrictMetricJpo> savedMetric = repository.getByDistrictIdAndMetricIdAndCropIdAndYear(metric.getDistrictId(), jpo.getMetricId(), jpo.getCropId(), jpo.getYear());
        if (!savedMetric.isEmpty()) {
            repository.deleteAll(savedMetric);
        }

        try {
           /* List<DistrictMetricJpo> jpoInDb = repository.getByDistrictIdAndMetricIdAndCropIdAndYear(metric.getDistrictId(), jpo.getMetricId(), jpo.getCropId(), jpo.getYear());
            if (!jpoInDb.isEmpty()) {
                jpo.setSequence(jpoInDb.get(0).getSequence());
            }*/
            repository.save(jpo);
        }
        catch (DataIntegrityViolationException exception) {
            throw new AlreadyExistsException("Data is already exists with these values");
        }
        return jpo.toDomain();
    }

    @Override
    public List<DistrictMetric> save(List<DistrictMetric> metrics) {
        List<DistrictMetricJpo> jpos = DistrictMetric.toJpos(metrics);
        jpos = repository.saveAll(jpos);
        return DistrictMetricJpo.toDomains(jpos);
    }

    @Override
    public DistrictMetric getById(Integer id) {
        return repository.getById(id).toDomain();
    }

    @Override
    public List<DistrictMetric> retrieveAll() {
        return DistrictMetricJpo.toDomains(repository.getAllBy());
    }

    @Override
    public List<DistrictMetric> retrieveByDistrictId(Integer districtId) {
        return DistrictMetricJpo.toDomains(repository.getAllByDistrictId(districtId));
    }

    @Override
    public List<DistrictMetric> retrieveByDistrictAndMetric(Integer districtId, Integer metricId) {
        return DistrictMetricJpo.toDomains(repository.findByDistrictIdAndMetricId(districtId, metricId));
    }

    @Override
    public List<DistrictMetric> retrieveByDistrictAndMetricAndCrop(Integer districtId, Integer metricId, Integer cropId) {
        return DistrictMetricJpo.toDomains(repository.getAllByDistrictIdAndMetricIdAndCropId(districtId, metricId, cropId));
    }
}
