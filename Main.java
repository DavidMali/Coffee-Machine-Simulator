package machine;

import java.util.Scanner;

import static machine.CoffeeMachine.*;

public class Main {
    /* In this case the main method handles taking user Input and passing it to the CoffeeMachine */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(coffeeMachine.coffeeMachineState.getStateMessage());
            String userChoice = scanner.nextLine();
            /* This part might be implemented too broadly considering that the exit option is not always available
            on the CoffeeMachine Display and therefore checking for it all the time is not efficient.
             */
            if (userChoice.equals("exit")) {
                scanner.close();
                return;
            }
            coffeeMachine.processUserChoice(userChoice); // Hand userChoice to the processing function
            }
        }
}



