package machine;

public enum CoffeeMachineState {

    MAIN_MENU("Write action (buy, fill, take, remaining, exit):") {
        @Override
        public CoffeeMachineState next(CoffeeMachine coffeeMachine, String input) {
            switch (input) {
                case "buy":
                    return BUYING_MENU;
                case "fill":
                    return FILLING_WATER;
                case "take":
                    coffeeMachine.takeMoney();
                    return MAIN_MENU;
                case "remaining":
                    coffeeMachine.printMachineContents();
                    return MAIN_MENU;
                case "exit":
                    return POWERED_OFF;
                default:
                    return MAIN_MENU;
            }
        }

    },

    BUYING_MENU("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:") {
        @Override
        public CoffeeMachineState next(CoffeeMachine coffeeMachine, String input) {
            if (coffeeMachine.buyBeverage(input)) {
                return MAIN_MENU;
            }
            return BUYING_MENU;
        }
    },

    FILLING_WATER("Write how many ml of water you want to add:") {
        @Override
        public CoffeeMachineState next(CoffeeMachine coffeeMachine, String input) {
            if (coffeeMachine.validatePositiveInteger(input)) {
                coffeeMachine.fillWater(Integer.parseInt(input));
                return FILLING_MILK;
            } else {
                System.out.println("Invalid input, please input a valid positive number.");
                return FILLING_WATER;
            }
        }
    },

    FILLING_MILK("Write how many ml of milk you want to add:") {
        @Override
        public CoffeeMachineState next(CoffeeMachine coffeeMachine, String input) {
            if (coffeeMachine.validatePositiveInteger(input)) {
                coffeeMachine.fillMilk(Integer.parseInt(input));
                return FILLING_COFFEE;
            } else {
                System.out.println("Invalid input, please input a valid positive number.");
                return FILLING_MILK;
            }
        }
    },

    FILLING_COFFEE("Write how many grams of coffee beans you want to add:") {
        @Override
        public CoffeeMachineState next(CoffeeMachine coffeeMachine, String input) {
            if (coffeeMachine.validatePositiveInteger(input)) {
                coffeeMachine.fillCoffeeBeans(Integer.parseInt(input));
                return FILLING_CUPS;
            } else {
                System.out.println("Invalid input, please input a valid positive number.");
                return FILLING_COFFEE;
            }
        }
    },

    FILLING_CUPS("Write how many cups you want to add:") {
        @Override
        public CoffeeMachineState next(CoffeeMachine coffeeMachine, String input) {
            if (coffeeMachine.validatePositiveInteger(input)) {
                coffeeMachine.fillCups(Integer.parseInt(input));
                return MAIN_MENU;
            } else {
                System.out.println("Invalid input, please input a valid positive number.");
                return FILLING_CUPS;
            }
        }
    },

    POWERED_OFF("Shutting down.") {
        @Override
        public CoffeeMachineState next(CoffeeMachine coffeeMachine, String input) {
            return null;
        }
    };

    private final String stateMessage;

    CoffeeMachineState(String stateMessage) {
        this.stateMessage = stateMessage;
    }

    public String getStateMessage() {
        return stateMessage;
    }


    public abstract CoffeeMachineState next(CoffeeMachine coffeeMachine, String input);

}
