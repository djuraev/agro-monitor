package uz.agromon.purchase.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import uz.agromon.purchase.domain.Purchase;
import uz.agromon.purchase.store.jpo.PurchaseJpo;

import java.util.List;

public interface PurchaseService {
    Purchase save(Purchase purchase);
    List<Purchase> getFarmerPurchases(String username);
    Page<PurchaseJpo> findByPage(int page, int pageSize);
    List<Purchase> getTenantPurchases(String tenantId);
}
