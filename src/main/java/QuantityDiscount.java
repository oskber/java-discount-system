public class QuantityDiscount extends BaseDiscount {
    @Override
    protected boolean isApplicable(Product product) {
        return product.quantity() >= 5;
    }

    @Override
    protected double calculateDiscount(Product product) {
        return 10.0;
    }

    @Override
    public void apply(Product product) {
        super.apply(product);
    }

    @Override
    public String getDiscountDescription(Product product) {

        return "Quantity discount";
    }
}
