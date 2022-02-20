package uz.agromon.tenant.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.agromon.tenant.store.jpo.ApiInfoJpo;

import java.util.List;

public interface ApiInfoRepository extends JpaRepository<ApiInfoJpo, Integer> {
    List<ApiInfoJpo> getAllBy();
    ApiInfoJpo getByApiName(String name);
    List<ApiInfoJpo> getAllByApiKey(String key);
}
