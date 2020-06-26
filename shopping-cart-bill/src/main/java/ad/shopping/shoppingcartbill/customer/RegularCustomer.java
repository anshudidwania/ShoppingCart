package ad.shopping.shoppingcartbill.customer;

import ad.shopping.shoppingcartbill.business.Slab;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
public class RegularCustomer implements Customer{

    private List<Slab> custSlabList;

    public RegularCustomer() {
        this.custSlabList = new ArrayList<>();
        Slab slab = Slab.builder()
                .startAmount(0d)
                .endAmount(5000d)
                .percentDiscount(0)
                .build();
        custSlabList.add(slab);
        slab = Slab.builder()
                .startAmount(5000d)
                .endAmount(10000d)
                .percentDiscount(10)
                .build();
        custSlabList.add(slab);
        slab = Slab.builder()
                .startAmount(10000d)
                .percentDiscount(20)
                .build();
        custSlabList.add(slab);
    }
    public RegularCustomer(List<Slab> custSlabList) {
        this();
    }

    @Override
    public List<Slab> getSlabList() {
        return getCustSlabList();
    }
}
