package uz.agromon.purchase.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.agromon.helper.APIResponse;
import uz.agromon.helper.ResponseBuilder;
import uz.agromon.purchase.domain.Purchase;
import uz.agromon.purchase.service.PurchaseService;

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
}
