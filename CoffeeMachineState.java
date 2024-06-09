package machine;

public enum CoffeeMachineState {
    BUYING_MENU("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:") {
        @Override
        public CoffeeMachineState next(CoffeeMachine coffeeMachine, String input) {
            if (coffeeMachine.buyBeverage(input)) {
                return ITEM_SELECTION;
            }
            return BUYING_MENU;
        }
    },

    ITEM_SELECTION("test") {
        @Override
        public CoffeeMachineState next(CoffeeMachine coffeeMachine, String input) {
            System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
            // CoffeeMachine.coffeeMachine.buyBeverage();
            return this;
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
