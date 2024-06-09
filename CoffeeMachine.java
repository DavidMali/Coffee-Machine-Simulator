package machine;

import static machine.CoffeeMachineState.*;

public class CoffeeMachine {

    private static final CoffeeMachine coffeeMachine = new CoffeeMachine(400, 540, 120, 9, 550);
    private int amountOfWater;
    private int amountOfMilk;
    private int amountOfCoffee;
    private int amountOfCups;
    private int amountOfMoney;
    private CoffeeMachineState coffeeMachineState;

    private CoffeeMachine(int amountOfWater, int amountOfMilk, int amountOfCoffee, int amountOfCups, int amountOfMoney) {
        this.amountOfWater = amountOfWater;
        this.amountOfMilk = amountOfMilk;
        this.amountOfCoffee = amountOfCoffee;
        this.amountOfCups = amountOfCups;
        this.amountOfMoney = amountOfMoney;
        this.coffeeMachineState = MAIN_MENU;
    }

    public static CoffeeMachine getInstance() {
        return coffeeMachine;
    }

    public CoffeeMachineState getCoffeeMachineState() {
        return coffeeMachineState;
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
        } catch (Exception e) {
            System.out.println("Invalid input, try again");
            return false;
        }

    }

    public void fillWater(int addedWater) {
        amountOfWater += addedWater;
    }

    public void fillMilk(int addedMilk) {
        amountOfMilk += addedMilk;
    }

    public void fillCoffeeBeans(int addedCoffeeBeans) {
        amountOfCoffee += addedCoffeeBeans;
    }

    public void fillCups(int addedCups) {
        amountOfCups += addedCups;
    }

    public void takeMoney() {
        System.out.println("I gave you $" + amountOfMoney);
        amountOfMoney = 0;
    }

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

    public boolean validatePositiveInteger(String input) {
        try {
            return Integer.parseInt(input) >= 0;

        } catch (NumberFormatException e) {
            return false;
        }
    }

}
