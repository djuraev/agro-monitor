package uz.agromon.purchase.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.agromon.purchase.store.jpo.PurchaseJpo;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<PurchaseJpo, Integer> {
    List<PurchaseJpo> getAllByFarmerName(String farmerName);
    List<PurchaseJpo> getAllByUsername(String username);
}
