package uz.agromon.purchase.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.agromon.helper.APIPagesResponse;
import uz.agromon.helper.APIResponse;
import uz.agromon.helper.ResponseBuilder;
import uz.agromon.purchase.domain.Purchase;
import uz.agromon.purchase.service.PurchaseService;
import uz.agromon.purchase.store.jpo.PurchaseJpo;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/api/purchase")
public class PurchaseResource {
    //
    @Autowired
    PurchaseService purchaseService;

    @PostMapping("/purchase")
    ResponseEntity<APIResponse> postFarmerPuchase(@RequestBody Purchase purchase) {
        Purchase savedPurchase = purchaseService.save(purchase);
        return ResponseBuilder.buildOk(savedPurchase);
    }

    @GetMapping("/purchases")
    ResponseEntity<APIPagesResponse> getAllPurchases(
            @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Page<PurchaseJpo> purchases = purchaseService.findByPage(page, size);
        return ResponseBuilder.buildOk(Collections.singletonList(purchases.getContent()), purchases.getTotalElements(), purchases.getNumber());
    }
}
