package ad.shopping.shoppingcartbill.services;

import ad.shopping.shoppingcartbill.business.GenerateBill;
import ad.shopping.shoppingcartbill.customer.CustomerFactory;
import ad.shopping.shoppingcartbill.customer.PremiumCustomer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class BillingServiceTest {
    @Mock
    private CustomerFactory customerFactory;

    @Mock
    private GenerateBill generateBill;

    @InjectMocks
    private BillingService billingService;

    @BeforeEach
    public void init() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(customerFactory.getCustomer(any(String.class))).thenReturn(PremiumCustomer.builder().build());
        when(generateBill.computeBill(any(ArrayList.class), any(Double.class))).thenReturn(10.00);
    }

    @Test
    public void computeBillTest_success() throws Exception {
        assertEquals(10.00,billingService.computeBillAmount("test", 10.00), "Computed bill service test success");
    }

    @Test
    public void computeBillTest_Exception() throws Exception {
        assertThrows(Exception.class, () -> billingService.computeBillAmount(null, 10.00), "Computed bill service throws exception");
    }

}