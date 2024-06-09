package machine;

import static machine.CoffeeMachineState.*;

public class CoffeeMachine {

    public static CoffeeMachine coffeeMachine = new CoffeeMachine(400, 540, 120, 9, 550);
    public int amountOfWater;
    public int amountOfMilk;
    public int amountOfCoffee;
    public int amountOfCups;
    public int amountOfMoney;
    public CoffeeMachineState coffeeMachineState;

    private CoffeeMachine(int amountOfWater, int amountOfMilk, int amountOfCoffee, int amountOfCups, int amountOfMoney) {
        this.amountOfWater = amountOfWater;
        this.amountOfMilk = amountOfMilk;
        this.amountOfCoffee = amountOfCoffee;
        this.amountOfCups = amountOfCups;
        this.amountOfMoney = amountOfMoney;
        this.coffeeMachineState = BUYING_MENU;
    }


    public void printMachineContents() {
        System.out.printf("The coffee machine has:\n" +
                "%d ml of water\n" +
                "%d ml of milk\n" +
                "%d g of coffee beans\n" +
                "%d disposable cups\n" +
                "$%d of money\n\n", amountOfWater, amountOfMilk, amountOfCoffee, amountOfCups, amountOfMoney);
    }

    public void processUserChoice(String choice) {
        coffeeMachineState = coffeeMachineState.next(this, choice);
        /*
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
        } */

    }

    public boolean buyBeverage(String userInput) {
        if (userInput.equalsIgnoreCase("back")) {
            return true;
        }
        try {
            int choice = Integer.parseInt(userInput);
            switch (choice) {
                case 1:
                    makeBeverage(Beverage.ESPRESSO);
                    return true;
                case 2:
                    makeBeverage(Beverage.LATTE);
                    return true;
                case 3:
                    makeBeverage(Beverage.CAPPUCCINO);
                    return true;
                default:
                    System.out.println("Invalid input, try again");
                    return false;
            }
        }  catch (Exception e) {
            System.out.println("Invalid input, try again");
            return false;
        }

    }

    /*

    public void fillMachine() {
        System.out.println("Write how many ml of water you want to add:");
        amountOfWater += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        amountOfMilk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        amountOfCoffee += scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        amountOfCups += scanner.nextInt();
    }

    public void takeMoney() {
        System.out.println("I gave you $" + amountOfMoney);
        amountOfMoney = 0;
    }
    */
    public void makeBeverage(Beverage beverage) {
        if (hasRequiredIngredients(beverage)) {
            System.out.println("I have enough resources, making you a coffee!");
            amountOfWater -= beverage.requiredWater;
            amountOfMilk -= beverage.requiredMilk;
            amountOfCoffee -= beverage.requiredCoffeeBeans;
            amountOfMoney += beverage.price;
            amountOfCups--;
        }
    }

    public boolean hasRequiredIngredients(Beverage beverage) {
        if (beverage.requiredWater > amountOfWater) {
            System.out.println("Sorry, not enough water!");
            return false;
        } else if (beverage.requiredMilk > amountOfMilk) {
            System.out.println("Sorry, not enough milk!");
            return false;
        } else if (beverage.requiredCoffeeBeans > amountOfCoffee) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        } else if (amountOfCups <= 0) {
            System.out.println("Sorry, not enough cups!");
            return false;
        }
        return true;
    }

}
