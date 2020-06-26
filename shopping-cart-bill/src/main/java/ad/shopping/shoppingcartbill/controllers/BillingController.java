package ad.shopping.shoppingcartbill.controllers;

import ad.shopping.shoppingcartbill.services.BillingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/bill")
public class BillingController {
    private final Logger logger = LoggerFactory.getLogger(BillingController.class);

    @Autowired
    private BillingService billingService;

    @GetMapping(path = "/{customer-type}/{bill-amount}")
    public Double computeBillAmount(@PathVariable("customer-type") String customerType, @PathVariable("bill-amount") Double billAmount) {
        Double discountedBill = null;
        try {
            validateInput(customerType, billAmount);
            discountedBill = billingService.computeBillAmount(customerType, billAmount);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return discountedBill;
    }

    private void validateInput(String customerType, Double billAmount) throws Exception {
        if(Objects.isNull(customerType) || Objects.isNull(billAmount))
            throw new Exception("Invalid Input");
    }

}
