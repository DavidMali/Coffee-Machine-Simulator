package machine;

import java.util.Scanner;

public class Main {
    /* In this case the main method handles taking user Input and passing it to the CoffeeMachine */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):"); // Replace this and instead let the
                                                                                    // CoffeeMachine handle it

            String userChoice = scanner.nextLine();
            /* This part might be implemented too broadly considering that the exit option is not always available
            on the CoffeeMachine Display and therefore checking for it all the time is not efficient.
             */
            if (userChoice.equals("exit")) {
                scanner.close();
                return;
            }
            CoffeeMachine.processUserChoice(userChoice); // Hand userChoice to the processing function
            }
        }
}



