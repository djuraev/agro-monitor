package uz.agromon.mobile.dto.response;

import uz.agromon.purchase.domain.Purchase;

import java.util.List;

public class FarmerInsurancePurchases extends Response{
    List<Purchase> purchases;

    public FarmerInsurancePurchases() {
        //
    }

    public FarmerInsurancePurchases(List<Purchase> purchases) {
        setResult(true);
        this.purchases = purchases;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }
}
