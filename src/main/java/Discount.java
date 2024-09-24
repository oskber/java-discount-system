public interface Discount {

    void apply(Product product);

    String getDescription(Product product);

    void setNextDiscount(Discount nextDiscount);
}
