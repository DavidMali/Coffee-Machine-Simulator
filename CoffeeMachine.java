package machine;

import java.util.Scanner;

public class CoffeeMachine {

    private static final Scanner scanner = new Scanner(System.in);
    private static final int waterPerCup = 200;
    private static final int milkPerCup = 50;
    private static final int coffeBeansPerCup = 15;

    public static void main(String[] args) {
        int waterAmount = promptForWaterAmount();
        int milkAmount = promptForMilkAmount();
        int coffeBeansAmount = promptForCoffeeBeansAmount();
        int possibleCoffeeCups = calculatePossibleCoffeeCups(waterAmount, milkAmount, coffeBeansAmount);
        int numberOfCups = promptForNumberOfCups();
        printPossibleCoffeCups(numberOfCups, possibleCoffeeCups);

        /* printRequiredIngredients(promptForNumberOfCups());
         System.out.println("Starting to make a coffee\n" +
                "Grinding coffee beans\n" +
                "Boiling water\n" +
                "Mixing boiled water with crushed coffee beans\n" +
                "Pouring coffee into the cup\n" +
                "Pouring some milk into the cup\n" +
                "Coffee is ready!"); */
        scanner.close();
    }

    public static int promptForNumberOfCups() {
        System.out.println("Write how many cups of coffee you will need:");
        return scanner.nextInt();
    }

    public static void printRequiredIngredients(int numberOfCups) {
        System.out.printf("For %d cups of coffee you will need:\n", numberOfCups);
        System.out.println(numberOfCups * waterPerCup + " ml of water");
        System.out.println(numberOfCups * milkPerCup + " ml of milk");
        System.out.println(numberOfCups * coffeBeansPerCup + " g of coffee beans");
    }

    public static int promptForWaterAmount() {
        System.out.println("Write how many ml of water the coffee machine has:");
        return scanner.nextInt();
    }

    public static int promptForMilkAmount() {
        System.out.println("Write how many ml of milk the coffee machine has:");
        return scanner.nextInt();
    }

    public static int promptForCoffeeBeansAmount() {
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        return scanner.nextInt();
    }

    public static int calculatePossibleCoffeeCups(int waterAmount, int milkAmount, int coffeeBeansAmount) {
        int possibleWaterCups = waterAmount / waterPerCup;
        int possibleMilkCups = milkAmount / milkPerCup;
        int possibleCoffeeBeansCups = coffeeBeansAmount / coffeBeansPerCup;
        int highestCommonDenominator;
        highestCommonDenominator = Math.min(possibleWaterCups, Math.min(possibleMilkCups, possibleCoffeeBeansCups));
        return highestCommonDenominator;
    }

    public static void printPossibleCoffeCups(int numberOfCups, int possibleCoffeeCups) {
        if (numberOfCups > possibleCoffeeCups) {
            System.out.println("No, I can make only " + possibleCoffeeCups +" cup(s) of coffee");
        } else if (numberOfCups == possibleCoffeeCups) {
            System.out.println("Yes, I can make that amount of coffee ");
        } else {
            System.out.println("Yes, I can make that amount of coffee (and even "
                    + (possibleCoffeeCups - numberOfCups) + " more than that)");
        }
    }
}
