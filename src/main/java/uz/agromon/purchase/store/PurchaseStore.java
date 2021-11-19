package uz.agromon.purchase.store;

import uz.agromon.purchase.domain.Purchase;

import java.util.List;

public interface PurchaseStore {
    Purchase save(Purchase purchase);
    List<Purchase> getFarmerPurchases(String farmerName);
}
