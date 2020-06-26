package ad.shopping.shoppingcartbill.customer;

import org.springframework.stereotype.Component;

@Component
public class CustomerFactory {

    public Customer getCustomer (String customerType){
        Customer customer = null;
        switch (customerType) {
            case "regular":
                customer = RegularCustomer.builder().build();
                break;
            case "premium":
                customer = PremiumCustomer.builder().build();
                break;
        }
        return customer;
    }
}
