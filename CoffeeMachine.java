package machine;

import java.util.Scanner;

public class CoffeeMachine {

    private static final Scanner scanner = new Scanner(System.in);
    public static int amountOfWater = 400;
    public static int amountOfMilk = 540;
    public static int amountOfCoffee = 120;
    public static int amountOfCups = 9;
    public static int amountOfMoney = 550;
    private static final Beverage espresso = new Beverage(250, 0, 16, 4);
    private static final Beverage latte = new Beverage(350, 75, 20, 7);
    private static final Beverage cappuccino = new Beverage(200, 100, 12, 6);
    /*
    private static final int waterPerCup = 200;
    private static final int milkPerCup = 50;
    private static final int coffeBeansPerCup = 15;
     */

    public static void main(String[] args) {
        printMachineContents();
        getUserChoice();
        /*int waterAmount = promptForWaterAmount();
        int milkAmount = promptForMilkAmount();
        int coffeBeansAmount = promptForCoffeeBeansAmount();
        int possibleCoffeeCups = calculatePossibleCoffeeCups(waterAmount, milkAmount, coffeBeansAmount);
        int numberOfCups = promptForNumberOfCups();
        printPossibleCoffeCups(numberOfCups, possibleCoffeeCups);

         printRequiredIngredients(promptForNumberOfCups());
         System.out.println("Starting to make a coffee\n" +
                "Grinding coffee beans\n" +
                "Boiling water\n" +
                "Mixing boiled water with crushed coffee beans\n" +
                "Pouring coffee into the cup\n" +
                "Pouring some milk into the cup\n" +
                "Coffee is ready!"); */
        scanner.close();
    }

    public static void printMachineContents() {
        System.out.printf("The coffee machine has:\n" +
                "%d ml of water\n" +
                "%d ml of milk\n" +
                "%d g of coffee beans\n" +
                "%d disposable cups\n" +
                "$%d of money\n\n", amountOfWater, amountOfMilk, amountOfCoffee, amountOfCups, amountOfMoney);
    }

    public static void getUserChoice() {
        System.out.println("Write action (buy, fill, take):");
        String choice = scanner.nextLine();
        switch (choice.toLowerCase()) {
            case "buy":
                buyBeverage();
                break;
            case "fill":
                fillMachine();
                break;
            case "take":
                takeMoney();
                break;
            case "remaining":
                printMachineContents();
            case "exit":
                return;
            default:
                getUserChoice();
        }
    }

    public static void buyBeverage() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                makeBeverage(espresso);
                break;
            case 2:
                makeBeverage(latte);
                break;
            case 3:
                makeBeverage(cappuccino);
                break;
            default:
                buyBeverage();
        }
    }

    public static void fillMachine() {
        System.out.println("Write how many ml of water you want to add:");
        amountOfWater += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        amountOfMilk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        amountOfCoffee += scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        amountOfCups += scanner.nextInt();
    }

    public static void takeMoney() {
        System.out.println("I gave you $" + amountOfMoney);
        amountOfMoney = 0;
    }

    public static void makeBeverage(Beverage beverage) {
       amountOfWater -= beverage.requiredWater;
       amountOfMilk -= beverage.requiredMilk;
       amountOfCoffee -= beverage.requiredCoffee;
       amountOfMoney += beverage.price;
       amountOfCups--;
    }


    /*
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
    } */
}
