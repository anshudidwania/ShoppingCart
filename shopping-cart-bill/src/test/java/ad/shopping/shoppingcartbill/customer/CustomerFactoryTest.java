package ad.shopping.shoppingcartbill.customer;

import ad.shopping.shoppingcartbill.services.BillingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class CustomerFactoryTest {

    @InjectMocks
    private CustomerFactory customerFactory;

    @BeforeEach
    public void init() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getCustomerTest_instanceOf() throws Exception {
        assertThat(customerFactory.getCustomer("regular")).isInstanceOf(Customer.class);
    }

    @Test
    public void getCustomerTest_emptyCustomer() throws Exception {
        assertEquals(null, customerFactory.getCustomer("test"), "Customer factory in-correct customer.");
    }

}