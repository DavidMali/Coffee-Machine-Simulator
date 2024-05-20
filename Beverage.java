package machine;

public class Beverage {

    int requiredWater;
    int requiredMilk;
    int requiredCoffee;
    int price;

    Beverage(int requiredWater, int requiredMilk, int requiredCoffee, int price) {
        this.requiredWater = requiredWater;
        this.requiredMilk = requiredMilk;
        this.requiredCoffee = requiredCoffee;
        this.price = price;
    }
}
