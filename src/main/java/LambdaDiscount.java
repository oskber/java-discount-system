public class LambdaDiscount extends BaseDiscount {
    private final IsApplicable isApplicable;
    private final CalculateDiscount calculateDiscount;
    private final String description;

    public LambdaDiscount(IsApplicable isApplicable, CalculateDiscount calculateDiscount, String description) {
        this.isApplicable = isApplicable;
        this.calculateDiscount = calculateDiscount;
        this.description = description;
    }

    @Override
    protected boolean isApplicable(Product product) {
        return isApplicable.isApplicable(product);
    }

    @Override
    protected double calculateDiscount(Product product) {
        return calculateDiscount.calculateDiscount(product);
    }

    @Override
    public void apply(Product product) {
        super.apply(product);
    }

    @Override
    public String getDiscountDescription(Product product) {
        return description;
    }
}
