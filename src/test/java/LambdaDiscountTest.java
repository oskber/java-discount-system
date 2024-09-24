import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LambdaDiscountTest {

    @Test
    void appliesChocolateMilkDiscount() {
        Product chocolateMilk = new Product("Chocolate Milk", 10.0, 1);
        Discount chocolateMilkDiscount = new LambdaDiscount(
                product -> product.name().equals("Chocolate Milk"),
                product -> product.price() * 0.05,
                "Chocolate Milk discount"
        );
        chocolateMilkDiscount.apply(chocolateMilk);
        assertThat(chocolateMilk.price()).isEqualTo(9.5);
    }

    @Test
    void appliesFridayDiscount() {
        Product pizza = new Product("Pizza", 100.0, 1);
        Discount fridayDiscount = new LambdaDiscount(
                product -> true,
                product -> product.price() * 0.1,
                "Friday discount"
        );
        fridayDiscount.apply(pizza);
        assertThat(pizza.price()).isEqualTo(90.0);
    }

    @Test
    void appliesMultipleDiscounts() {
        Product chocolateMilk = new Product("Chocolate Milk", 20.0, 1);
        Discount chocolateMilkDiscount = new LambdaDiscount(
                product -> product.name().equals("Chocolate Milk"),
                product -> product.price() * 0.05,
                "Chocolate Milk discount"
        );
        Discount fridayDiscount = new LambdaDiscount(
                product -> true,
                product -> product.price() * 0.1,
                "Friday discount"
        );
        chocolateMilkDiscount.setNextDiscount(fridayDiscount);
        chocolateMilkDiscount.apply(chocolateMilk);
        assertThat(chocolateMilk.price()).isEqualTo(17.1);
    }
}
