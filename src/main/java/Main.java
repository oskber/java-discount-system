public class Main {
    public static void main(String[] args) {
        Product chocolateMilk = new Product("Chocolate milk", 20.0, 1);
        Discount chocolateMilkDiscount = new LambdaDiscount(
                product -> product.name().equals("Chocolate milk"),
                product -> product.price() * 0.05,
                "Chocolate milk discount"
        );
        Discount fridayDiscount = new LambdaDiscount(
                product -> true,
                product -> product.price() * 0.1,
                "Friday discount"
        );

        chocolateMilkDiscount.setNextDiscount(fridayDiscount);
        chocolateMilkDiscount.apply(chocolateMilk);
        System.out.println("Final price for chocolate milk: " + chocolateMilk.price());
        System.out.println("Discount description: " + chocolateMilkDiscount.getDescription(chocolateMilk));

        Product milk = new Product("Milk", 10.0, 1);
        Discount milkDiscount = new MilkDiscount();
        fridayDiscount = new FridayDiscount();
        milkDiscount.setNextDiscount(fridayDiscount);
        milkDiscount.apply(milk);
        System.out.println("Final price for milk: " + milk.price());
        System.out.println("Discount description: " + milkDiscount.getDescription(milk));

        Product pizza = new Product("pizza", 100.0, 5);
        Discount quantityDiscount = new QuantityDiscount();
        fridayDiscount = new FridayDiscount();
        quantityDiscount.setNextDiscount(fridayDiscount);
        quantityDiscount.apply(pizza);
        System.out.println("Final price for pizza: " + pizza.price());
        System.out.println("Discount description: " + quantityDiscount.getDescription(pizza));
        double totalPriceForPizzas = pizza.price() * pizza.quantity();
        System.out.println("Total price for pizzas: " + totalPriceForPizzas);
    }
}
