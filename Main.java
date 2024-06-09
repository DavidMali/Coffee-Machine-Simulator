package machine;

import java.util.Scanner;

public class Main {
    /* In this case the main method handles taking user Input and passing it to the CoffeeMachine */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine coffeeMachine = CoffeeMachine.getInstance();
        CoffeeMachineState coffeeMachineState = coffeeMachine.getCoffeeMachineState();

        while (!(coffeeMachineState == CoffeeMachineState.POWERED_OFF)) {
            System.out.println(coffeeMachineState.getStateMessage());
            String userInput = scanner.nextLine();
            coffeeMachine.processUserChoice(userInput); // Hand userInput to the processing function
            coffeeMachineState = coffeeMachine.getCoffeeMachineState();
        }
        scanner.close();
        System.exit(0);
    }


}



