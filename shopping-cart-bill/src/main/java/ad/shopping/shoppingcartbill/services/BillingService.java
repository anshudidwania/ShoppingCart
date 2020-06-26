package ad.shopping.shoppingcartbill.services;

import ad.shopping.shoppingcartbill.business.GenerateBill;
import ad.shopping.shoppingcartbill.customer.Customer;
import ad.shopping.shoppingcartbill.customer.CustomerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class BillingService {

    @Autowired
    private CustomerFactory customerFactory;

    @Autowired
    private GenerateBill generateBill;

    public Double computeBillAmount(String customerType, Double billAmount) throws Exception {
        Customer cust = customerFactory.getCustomer(customerType);
        if(Objects.isNull(cust)) throw new Exception("Customer type not found");
        return generateBill.computeBill(cust.getSlabList(), billAmount);
    }
}
