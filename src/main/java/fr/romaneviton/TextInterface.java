package fr.romaneviton;
import java.util.Scanner;

public class TextInterface {
    private Scanner scanner;

    public TextInterface() {
        scanner = new Scanner(System.in);
    }

    public void close() {
        scanner.close();
    }

    public MenuOptions.MainMenu mainMenu() {
        int choice;

        while (true) {
            System.out.println("===== MAIN MENU =====");
            System.out.println("1. NEW GAME");
            System.out.println("2. QUIT");
            System.out.print("Please select an option: ");

            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    return MenuOptions.MainMenu.NEWGAME;
                case 2:
                    return MenuOptions.MainMenu.QUIT;
                default:
                    System.out.println("Your choice is invalid. Please enter a valid option.");
            }
        }
    }

    public MenuOptions.GameMenu gameMenu() {
        int gameChoice;

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
                    return MenuOptions.GameMenu.QUIT;
                default:
                    System.out.println("Your choice is invalid. Please enter a valid option.");
            }
        }
    }
}

