package ad.shopping.shoppingcartbill.controllers;

import ad.shopping.shoppingcartbill.services.BillingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class BillingControllerTest {

    @Mock
    private BillingService billingService;

    @InjectMocks
    private BillingController billingController;

    @BeforeEach
    public void init() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(billingService.computeBillAmount(any(String.class), any(Double.class))).thenReturn(10.00);
    }

    @Test
    public void computeBillAmountTest_success()  {
        assertEquals(10.00,billingController.computeBillAmount("test", 12.00), "Computed bill test success");
    }

    @Test
    public void computeBillAmountTest_validateInput() {
        assertAll(() -> {
            assertEquals(null,billingController.computeBillAmount("test", null), "Bill amount invalid");
            assertEquals(null,billingController.computeBillAmount(null, 12.00), "Customer type amount invalid");
        });
        //assertThrows(Exception.class, () -> billingController.computeBillAmount("test", null), "Computed bill throws exception");
    }
}