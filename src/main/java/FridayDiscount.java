import java.time.LocalDate;
import java.util.Locale;

public class FridayDiscount extends BaseDiscount{
    @Override
    protected boolean isApplicable(Product product) {
        return isFriday();
    }

    private boolean isFriday() {
        return true;
        //LocalDate.now().getDayOfWeek().toString().toLowerCase(Locale.ROOT).equals("friday");
    }

    @Override
    protected double calculateDiscount(Product product) {
        return product.price() * 0.1;
    }

    @Override
    public void apply(Product product) {
        super.apply(product);
}

    @Override
    public String getDiscountDescription(Product product) {
        return "Friday discount";
    }
}
