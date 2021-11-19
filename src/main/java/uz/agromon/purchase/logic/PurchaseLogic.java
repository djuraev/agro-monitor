package uz.agromon.purchase.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.agromon.purchase.domain.Purchase;
import uz.agromon.purchase.service.PurchaseService;
import uz.agromon.purchase.store.PurchaseStore;

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
}
