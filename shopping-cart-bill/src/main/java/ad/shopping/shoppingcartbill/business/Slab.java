package ad.shopping.shoppingcartbill.business;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Slab {
    private Double startAmount;
    private Double endAmount;
    private Integer percentDiscount;
}
