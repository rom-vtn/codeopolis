package fr.romaneviton;
import java.util.Scanner;

public class TextInterface {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean endMenu;

        while (true) {
            System.out.println("===== MAIN MENU =====");
            System.out.println("1. NEW GAME");
            System.out.println("2. QUIT");
            System.out.print("Please select an option: ");

            choice = scanner.nextInt();
            endMenu = false;
            switch (choice) {
                case 1:
                    gameMenu(scanner);
                    break;
                case 2:
                    endMenu = true;
                    break;
                default:
                    System.out.println("Your choice is invalid. Please enter a valid option.");
            }
            if (endMenu) {
                break;
            }
        }
        scanner.close();
    }

    public static void gameMenu(java.util.Scanner scanner) {
        int gameChoice;
        boolean endMenu;

        while (true) {
            System.out.println("===== GAME MENU =====");
            System.out.println("1. BUY");
            System.out.println("2. SELL");
            System.out.println("3. FEED");
            System.out.println("4. PLANT");
            System.out.println("5. SHOW STATUS");
            System.out.println("6. QUIT GAME");
            System.out.print("Please select an action: ");

            gameChoice = scanner.nextInt();
            endMenu = false;
            switch (gameChoice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    endMenu = true;
                    break;
                default:
                    System.out.println("Your choice is invalid. Please enter a valid option.");
            }
            if (endMenu) {
                break;
            }
        }
    }
}

