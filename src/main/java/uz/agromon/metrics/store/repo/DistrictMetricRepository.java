package uz.agromon.metrics.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.agromon.metrics.store.jpo.DistrictMetricJpo;

import java.util.List;

public interface DistrictMetricRepository extends JpaRepository<DistrictMetricJpo, Integer> {
    List<DistrictMetricJpo> getAllBy();
    List<DistrictMetricJpo> getAllByDistrictId(Integer districtId);
    List<DistrictMetricJpo> findAllByDistrictIdAndMetricId(Integer districtId, Integer metricId);
    List<DistrictMetricJpo> findByDistrictIdAndMetricId(Integer districtId, Integer metricId);
    List<DistrictMetricJpo> getAllByDistrictIdAndMetricIdAndCropId(Integer districtId, Integer metricId, Integer cropId);
    List<DistrictMetricJpo> getByDistrictIdAndMetricIdAndCropIdAndYear(Integer did, Integer mid, Integer cropId, String year);
}
