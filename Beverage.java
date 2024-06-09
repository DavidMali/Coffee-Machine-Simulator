package machine;

public enum Beverage {
    ESPRESSO(250, 0, 16, 4),
    LATTE(350, 75, 20, 7),
    CAPPUCCINO(200, 100, 12, 6);

    final int requiredWater;
    final int requiredMilk;
    final int requiredCoffeeBeans;
    final int price;

    Beverage(int requiredWater, int requiredMilk, int requiredCoffeeBeans, int price) {
        this.requiredWater = requiredWater;
        this.requiredMilk = requiredMilk;
        this.requiredCoffeeBeans = requiredCoffeeBeans;
        this.price = price;
    }
}
