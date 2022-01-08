package uz.agromon.purchase.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.agromon.purchase.domain.Purchase;
import uz.agromon.purchase.service.PurchaseService;
import uz.agromon.purchase.store.PurchaseStore;
import uz.agromon.purchase.store.jpo.PurchaseJpo;

import java.util.List;

@Service
public class PurchaseLogic implements PurchaseService {
    @Autowired
    PurchaseStore purchaseStore;

    @Override
    public Purchase save(Purchase purchase) {
        return purchaseStore.save(purchase);
    }

    @Override
    public List<Purchase> getFarmerPurchases(String username) {
        return purchaseStore.getFarmerPurchases(username);
    }

    @Override
    public Page<PurchaseJpo> findByPage(int page, int pageSize) {
        return purchaseStore.findAll(page, pageSize);
    }

}
