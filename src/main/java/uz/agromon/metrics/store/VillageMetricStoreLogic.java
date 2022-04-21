package uz.agromon.metrics.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import uz.agromon.config.exception.klass.AlreadyExistsException;
import uz.agromon.metrics.domain.VillageMetric;
import uz.agromon.metrics.store.jpo.DistrictMetricJpo;
import uz.agromon.metrics.store.jpo.VillageMetricJpo;
import uz.agromon.metrics.store.repo.VillageMetricRepository;
import uz.agromon.user.store.jpo.UserJpo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class VillageMetricStoreLogic implements VillageMetricStore {

    @Autowired
    VillageMetricRepository repository;

    @Override
    public VillageMetric save(VillageMetric metric) throws AlreadyExistsException {
        VillageMetricJpo jpo = new VillageMetricJpo(metric);
        try {
            repository.save(jpo);
        }
        catch (DataIntegrityViolationException exception) {
            throw new AlreadyExistsException("Data is already exists with these values");
        }
        return jpo.toDomain();
    }

    @Override
    public List<VillageMetric> saveAll(List<VillageMetric> metric) {
        List<VillageMetricJpo> jpos = VillageMetric.toJpos(metric);
        jpos = repository.saveAll(jpos);
        return VillageMetricJpo.toDomains(jpos);
    }

    @Override
    public VillageMetric getById(Integer id) {
        return repository.getById(id).toDomain();
    }

    @Override
    public List<VillageMetric> getAll() {
        return VillageMetricJpo.toDomains(repository.getAllBy());
    }

    @Override
    public List<VillageMetric> getVillageMetrics(Integer villageId) {
        return VillageMetricJpo.toDomains(repository.getAllByVillageId(villageId));
    }

    @Override
    public List<VillageMetric> getVillageMetrics(Integer villageId, Integer metricId) {
        return VillageMetricJpo.toDomains(repository.getAllByVillageIdAndMetricId(villageId, metricId));
    }

    @Override
    public List<VillageMetric> getVillageMetrics(Integer villageId, Integer metricId, Integer cropId) {
        return VillageMetricJpo.toDomains(repository.getAllByVillageIdAndMetricIdAndCropId(villageId, metricId, cropId));
    }

    @Override
    public List<VillageMetric> getAllBy(VillageMetric villageMetric) {
        VillageMetricJpo jpo = new VillageMetricJpo(villageMetric);
        Example<VillageMetricJpo> vm = Example.of(jpo);
        //Get all pages
        Pageable page = PageRequest.of(0, Integer.MAX_VALUE);
        Page<VillageMetricJpo> responsePage = repository.findAll(vm, page);
        List<VillageMetricJpo> jpos = responsePage.getContent();

        return VillageMetricJpo.toDomains(jpos);
    }
}
