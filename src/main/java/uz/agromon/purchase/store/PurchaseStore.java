package uz.agromon.purchase.store;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import uz.agromon.purchase.domain.Purchase;
import uz.agromon.purchase.store.jpo.PurchaseJpo;

import java.util.List;

public interface PurchaseStore {
    Purchase save(Purchase purchase);
    List<Purchase> getFarmerPurchases(String farmerName);
    Page<PurchaseJpo> findAll(int page, int pageSize);
}
