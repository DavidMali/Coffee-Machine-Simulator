package machine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String choice = scanner.nextLine();
            if (choice.equals("exit")) {
                scanner.close();
                return;
            }
            CoffeeMachine.processUserChoice(choice);
            }
        }
}



