public abstract class BaseDiscount implements Discount {
    private Discount nextDiscount;

    public void setNextDiscount(Discount nextDiscount) {
        this.nextDiscount = nextDiscount;
    }

    @Override
    public void apply(Product product) {
        if (isApplicable(product)) {
            double newPrice = product.price() - calculateDiscount(product);
            product.setPrice(newPrice);
        }
        if (nextDiscount != null) {
            nextDiscount.apply(product);
        }
    }

    @Override
    public String getDescription(Product product) {
        String description = "No discount";
        if (isApplicable(product)) {
            description = getDiscountDescription(product);
        }
        if (nextDiscount != null) {
            description += ", " + nextDiscount.getDescription(product);
        }
        return description;
    }

    protected abstract boolean isApplicable(Product product);

    protected abstract double calculateDiscount(Product product);

    protected abstract String getDiscountDescription(Product product);
}