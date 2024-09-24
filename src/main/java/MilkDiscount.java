public class MilkDiscount extends BaseDiscount {
    @Override
    protected boolean isApplicable(Product product) {
        return true;
    }

    @Override
    protected double calculateDiscount(Product product) {
        return product.price() * 0.05;
    }

    @Override
    public void apply(Product product) {
        super.apply(product);
    }

    @Override
    public String getDiscountDescription(Product product) {

        return "Milk discount";
    }
}
