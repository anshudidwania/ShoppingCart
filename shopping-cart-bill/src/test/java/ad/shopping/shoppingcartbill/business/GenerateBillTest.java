package ad.shopping.shoppingcartbill.business;

import ad.shopping.shoppingcartbill.customer.PremiumCustomer;
import ad.shopping.shoppingcartbill.services.BillingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class GenerateBillTest {

    @InjectMocks
    private GenerateBill generateBill;

    @BeforeEach
    public void init() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void computeBillTest_success() throws Exception {
        List<Slab> custSlabList = new ArrayList<>();
        Slab slab = Slab.builder().startAmount(0d).endAmount(4000d).percentDiscount(10).build();
        custSlabList.add(slab);
        slab = Slab.builder().startAmount(4000d).endAmount(8000d).percentDiscount(15).build();
        custSlabList.add(slab);
        slab = Slab.builder().startAmount(8000d).endAmount(12000d).percentDiscount(20).build();
        custSlabList.add(slab);
        slab = Slab.builder().startAmount(12000d).percentDiscount(30).build();
        custSlabList.add(slab);
        assertEquals(8600.00,generateBill.computeBill(custSlabList, 10000.00), "Generate bill test success");
    }

}