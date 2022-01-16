package uz.agromon.purchase.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import uz.agromon.purchase.domain.Purchase;
import uz.agromon.purchase.store.jpo.PurchaseJpo;
import uz.agromon.purchase.store.repo.PurchaseRepository;

import java.util.List;

@Repository
public class PurchaseStoreLogic implements PurchaseStore {
    @Autowired
    PurchaseRepository repository;

    @Override
    public Purchase save(Purchase purchase) {
        PurchaseJpo jpo = new PurchaseJpo(purchase);
        return repository.save(jpo).toDomain();
    }

    @Override
    public List<Purchase> getFarmerPurchases(String farmerName) {
        List<PurchaseJpo> jpos = repository.getAllByUsername(farmerName);
        return PurchaseJpo.toDomains(jpos);
    }

    @Override
    public Page<PurchaseJpo> findAll(int page, int pageSize) {
        Pageable paging = PageRequest.of(page, pageSize);
        return repository.findAllBy(paging);
    }

}
