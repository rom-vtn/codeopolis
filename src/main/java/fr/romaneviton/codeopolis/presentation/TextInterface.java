package fr.romaneviton.codeopolis.presentation;
import fr.romaneviton.codeopolis.domainmodel.DifficultyLevel;
import fr.romaneviton.codeopolis.domainmodel.TurnResult;

import java.util.Scanner;
import fr.romaneviton.codeopolis.domainmodel.City;

public class TextInterface implements fr.romaneviton.codeopolis.domainmodel.UserInterface {
    private Scanner scanner;

    public TextInterface() {
        scanner = new Scanner(System.in);
    }

    public void close() {
        scanner.close();
    }

    public String askCityName(String prompt) { //NOTE not connected to Game for now
        String cityName = "";
        outputln(prompt);
        while (cityName.equals("")) {
            output("> ");
            cityName = scanner.nextLine();
        }
        return cityName;
    }

    public DifficultyLevel askDifficultyLevel() { //NOTE not connected to Game for now
        int choice;

        while (true) {
            outputln("===== DIFFICULTY LEVEL =====");
            outputln("1. EASY");
            outputln("2. MEDIUM");
            outputln("3. HARD");
            output("Please select an option: ");

            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    return DifficultyLevel.EASY;
                case 2:
                    return DifficultyLevel.MEDIUM;
                case 3:
                    return DifficultyLevel.HARD;
                default:
                    outputln("Your choice is invalid. Please enter a valid option.");
            }
        }
    }

    public enum MainMenuOptions {
        NEWGAME,
        QUIT
    }
    public MainMenuOptions mainMenu() {
        int choice;

        while (true) {
            outputln("===== MAIN MENU =====");
            outputln("1. NEW GAME");
            outputln("2. QUIT");
            output("Please select an option: ");

            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    return MainMenuOptions.NEWGAME;
                case 2:
                    return MainMenuOptions.QUIT;
                default:
                    outputln("Your choice is invalid. Please enter a valid option.");
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
            outputln("===== GAME MENU =====");
            outputln("1. BUY");
            outputln("2. SELL");
            outputln("3. FEED");
            outputln("4. PLANT");
            outputln("5. SHOW STATUS");
            outputln("6. QUIT GAME");
            output("Please select an action: ");

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
                    outputln("Your choice is invalid. Please enter a valid option.");
            }
        }
    }

    public int buy(int pricePerAcre, City city) {
        outputln("===== BUY MENU =====");
        outputln("Current state : " + city.toString());
        outputln("Current price per acre : " + pricePerAcre);
        outputln("How many acres to buy?");

        output("> ");
        return scanner.nextInt();
    }

    public int sell(int pricePerAcre, City city) {
        outputln("===== SELL MENU =====");
        outputln("Current state : " + city.toString());
        outputln("Current price per acre : " + pricePerAcre);
        outputln("How many acres to sell?");

        output("> ");
        return scanner.nextInt();
    }

    public int feed(int bushelsPerResident, City city) {
        outputln("===== FEED MENU =====");
        outputln("Current state : " + city.toString());
        outputln("Each resident requires " + bushelsPerResident + " bushels of food.");
        outputln("How many bushels to feed?");

        output("> ");
        return scanner.nextInt() / bushelsPerResident; //divide to conform to spec
    }

    public int plant(int bushelsPerAcre, int acresPerResident, City city) {
        outputln("===== PLANT MENU =====");
        outputln("Current state : " + city.toString());
        outputln(bushelsPerAcre + " bushels per acre, " + acresPerResident + " acres per resident.");
        outputln("How many acres to plant?");

        output("> ");
        return scanner.nextInt();
    }

    public void showStatus(City city) {
        outputln("Current state: " + city.toString());
    }

    public void turnEnd(TurnResult turnResult) {
        outputln("Result of year " + turnResult.getYear() + " :");
        outputln(turnResult.toString()); //TODO implement toString
    }

    public void illegalInput(String s) {
        outputln("Illegal input: " + s);
    }

    public void gameLost(String s) {
        outputln("GAME LOST: " + s);
    }

    public void gameWon(String s) {
        outputln("GAME WON: " + s);
    }

    private void outputln(String s) {
        output(s + "\r\n"); //TODO CRLF is not universal
    }

    private void output(String s) {
        //Allows to set custom output stream
        System.out.print(s);
    }
}

