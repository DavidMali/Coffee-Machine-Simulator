package machine;

import java.util.Scanner;

import static machine.CoffeeMachine.*;

public class Main {
    /* In this case the main method handles taking user Input and passing it to the CoffeeMachine */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (!(coffeeMachine.coffeeMachineState == CoffeeMachineState.POWERED_OFF)) {
            System.out.println(coffeeMachine.coffeeMachineState.getStateMessage());
            String userInput = scanner.nextLine();
            coffeeMachine.processUserChoice(userInput); // Hand userInput to the processing function
        }
        scanner.close();
        System.exit(0);
    }


}



