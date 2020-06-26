package ad.shopping.shoppingcartbill.business;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class GenerateBill {

    public Double computeBill(List<Slab> slabLs, Double billAmt){
        List<Double> disAmtLs = slabLs.stream().map(s -> calculateDiscount(s, billAmt)).collect(Collectors.toList());
        return billAmt - disAmtLs.stream().mapToDouble(a -> a).sum();
    }

    private Double calculateDiscount(Slab slab, Double billAmt){
        if(billAmt > slab.getStartAmount() ){
            if(Objects.isNull(slab.getEndAmount()) || billAmt < slab.getEndAmount())
                return (billAmt - slab.getStartAmount()) * slab.getPercentDiscount()/100;
            else
                return (slab.getEndAmount() - slab.getStartAmount()) * slab.getPercentDiscount()/100;

        }else return 0d;
    }
}
