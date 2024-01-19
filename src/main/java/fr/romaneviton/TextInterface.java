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

    public String askCityName(String prompt) {
        String cityName = "";
        System.out.println(prompt);
        while (cityName.equals("")) {
            System.out.print(">");
            cityName = scanner.nextLine();
        }
        return cityName;
    }

    public enum MainMenuOptions {
        NEWGAME,
        QUIT
    }
    public MainMenuOptions mainMenu() {
        int choice;

        while (true) {
            System.out.println("===== MAIN MENU =====");
            System.out.println("1. NEW GAME");
            System.out.println("2. QUIT");
            System.out.print("Please select an option: ");

            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    return MainMenuOptions.NEWGAME;
                case 2:
                    return MainMenuOptions.QUIT;
                default:
                    System.out.println("Your choice is invalid. Please enter a valid option.");
            }
        }
    }

    public enum GameMenuOptions {
        BUY,
        SELL,
        FEED,
        PLANT,
        SHOW_STATUS,
        QUIT
    }
    public GameMenuOptions gameMenu() {
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
                    return GameMenuOptions.BUY;
                case 2:
                    return GameMenuOptions.SELL;
                case 3:
                    return GameMenuOptions.FEED;
                case 4:
                    return GameMenuOptions.PLANT;
                case 5:
                    return GameMenuOptions.SHOW_STATUS;
                case 6:
                    return GameMenuOptions.QUIT;
                default:
                    System.out.println("Your choice is invalid. Please enter a valid option.");
            }
        }
    }

    public void buyMenu(City city, int acrePrice) {
        int userInput = 0;
        System.out.println(" --- BUY MENU --- ");
        System.out.println("Current state : " + city.toString());
        System.out.println("Current price per acre : " + acrePrice);
        System.out.println("How many acres to buy?");

        while (true) {
            System.out.print(">");
            userInput = scanner.nextInt();
            if (city.buy(userInput, acrePrice)) {
                break;
            } else {
                System.out.println("Not enough to buy!");
            }
        }

        System.out.println("New status: " + city.toString());
    }

    public void sellMenu(City city, int acrePrice) {
        int userInput = 0;
        System.out.println(" --- SELL MENU --- ");
        System.out.println("Current state : " + city.toString());
        System.out.println("Current price per acre : " + acrePrice);
        System.out.println("How many acres to sell?");

        while (true) {
            System.out.print(">");
            userInput = scanner.nextInt();
            if (city.sell(userInput, acrePrice)) {
                break;
            } else {
                System.out.println("Not enough land to sell!");
            }
        }

        System.out.println("New status: " + city.toString());
    }

    public void feedMenu(City city) {
        int userInput = 0;
        System.out.println(" --- FEED MENU --- ");
        System.out.println("Current state : " + city.toString());
        System.out.println("How many bushels to feed?");

        while (true) {
            System.out.print(">");
            userInput = scanner.nextInt();
            if (city.feed(userInput)) {
                break;
            } else {
                System.out.println("Not enough bushels to feed!");
            }
        }

        System.out.println("New status: " + city.toString());
    }

    public void plantMenu(City city) {
        int userInput = 0;
        System.out.println(" --- PLANT MENU --- ");
        System.out.println("Current state : " + city.toString());
        System.out.println("How many acres to plant?");

        while (true) {
            System.out.print(">");
            userInput = scanner.nextInt();
            if (city.plant(userInput)) {
                break;
            } else {
                System.out.println("Requirements not satisfied!");
            }
        }
    }

    public void showStatus(City city) {
        System.out.println("Current state: " + city.toString());
    }
}

