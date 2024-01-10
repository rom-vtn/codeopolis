package fr.romaneviton;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("===== MAIN MENU =====");
            System.out.println("1. NEW GAME");
            System.out.println("2. QUIT");
            System.out.print("Please select an option: ");

            int choice = scanner.nextInt();
            boolean endMenu = false;
            switch (choice) {
                case 1:
                    gameMenu();
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

    public static void gameMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===== GAME MENU =====");
            System.out.println("1. BUY");
            System.out.println("2. SELL");
            System.out.println("3. FEED");
            System.out.println("4. PLANT");
            System.out.println("5. SHOW STATUS");
            System.out.println("6. QUIT GAME");
            System.out.print("Please select an action: ");

            int gameChoice = scanner.nextInt();
            boolean endMenu = false;
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
        scanner.close();
    }
}

