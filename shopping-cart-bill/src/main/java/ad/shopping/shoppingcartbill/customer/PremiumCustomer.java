package ad.shopping.shoppingcartbill.customer;

import ad.shopping.shoppingcartbill.business.Slab;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
public class PremiumCustomer implements Customer{
    private List<Slab> custSlabList;

    public PremiumCustomer() {
        this.custSlabList = new ArrayList<>();
        Slab slab = Slab.builder()
                .startAmount(0d)
                .endAmount(4000d)
                .percentDiscount(10)
                .build();
        custSlabList.add(slab);
        slab = Slab.builder()
                .startAmount(4000d)
                .endAmount(8000d)
                .percentDiscount(15)
                .build();
        custSlabList.add(slab);
        slab = Slab.builder()
                .startAmount(8000d)
                .endAmount(12000d)
                .percentDiscount(20)
                .build();
        custSlabList.add(slab);
        slab = Slab.builder()
                .startAmount(12000d)
                .percentDiscount(30)
                .build();
        custSlabList.add(slab);
    }
    public PremiumCustomer(List<Slab> custSlabList) {
        this();
    }

    @Override
    public List<Slab> getSlabList() {
        return getCustSlabList();
    }
}
