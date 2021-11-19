package uz.agromon.purchase.service;

import uz.agromon.purchase.domain.Purchase;

import java.util.List;

public interface PurchaseService {
    Purchase save(Purchase purchase);
    List<Purchase> getFarmerPurchases(String username);
}
