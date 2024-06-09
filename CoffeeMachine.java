package machine;

import java.util.Scanner;

public class CoffeeMachine {

    private static final Scanner scanner = new Scanner(System.in);
    public static int amountOfWater = 400;
    public static int amountOfMilk = 540;
    public static int amountOfCoffee = 120;
    public static int amountOfCups = 9;
    public static int amountOfMoney = 550;
    private enum machineState {
        DEFAULT, BUY, FILL, TAKEMONEY, REMAINING
    }


    public static void printMachineContents() {
        System.out.printf("The coffee machine has:\n" +
                "%d ml of water\n" +
                "%d ml of milk\n" +
                "%d g of coffee beans\n" +
                "%d disposable cups\n" +
                "$%d of money\n\n", amountOfWater, amountOfMilk, amountOfCoffee, amountOfCups, amountOfMoney);
    }

    public static void processUserChoice(String choice) {
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
                break;
        }

    }

    public static void buyBeverage() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String userInput = scanner.nextLine();
        if (userInput.equalsIgnoreCase("back")) {
            return;
        }
        try {
            int choice = Integer.parseInt(userInput);
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
        }  catch (Exception e) {
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
        if (hasRequiredIngredients(beverage)) {
            System.out.println("I have enough resources, making you a coffee!");
            amountOfWater -= beverage.requiredWater;
            amountOfMilk -= beverage.requiredMilk;
            amountOfCoffee -= beverage.requiredCoffee;
            amountOfMoney += beverage.price;
            amountOfCups--;
        }
    }

    public static boolean hasRequiredIngredients(Beverage beverage) {
        if (beverage.requiredWater > amountOfWater) {
            System.out.println("Sorry, not enough water!");
            return false;
        } else if (beverage.requiredMilk > amountOfMilk) {
            System.out.println("Sorry, not enough milk!");
            return false;
        } else if (beverage.requiredCoffee > amountOfCoffee) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        } else if (amountOfCups <= 0) {
            System.out.println("Sorry, not enough cups!");
            return false;
        }
        return true;
    }

}
