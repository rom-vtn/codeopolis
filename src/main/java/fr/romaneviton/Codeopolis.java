package fr.romaneviton;

import dev.codeopolis.increment03.TurnResult;

public class Codeopolis {
    public static void main(String[] args) {
        int ACRE_PRICE = 40; //TODO: make prices variable later
        TextInterface textInterface = new TextInterface();
        City city; 
        TurnResult turnResult;
        boolean gameWon = false;
        while (textInterface.mainMenu() != TextInterface.MainMenuOptions.QUIT) {
            // Main menu
            // TextInterface.GameMenuOptions gameMenuOption = textInterface.gameMenu();
            // while (gameMenuOption != TextInterface.GameMenuOptions.QUIT) {
            //     switch (gameMenuOption) {
            //         case BUY:
            //             textInterface.buyMenu(city, ACRE_PRICE);
            //             break;
            //         case SELL:
            //             textInterface.sellMenu(city, ACRE_PRICE);
            //             break;
            //         case FEED:
            //             textInterface.feedMenu(city);
            //             break;
            //         case PLANT:
            //             textInterface.plantMenu(city);
            //             break;
            //         case SHOW_STATUS:
            //             textInterface.showStatus(city);
            //             break; 
            //         default:
            //             //this should never be run
            //             break;
            //     }
            //     gameMenuOption = textInterface.gameMenu();
            // }
            city = new City(textInterface.askCityName("What's that name of your city? "));
            while (true) { //TODO: add quit condition or death condition
                // do interface stuff
                textInterface.showStatus(city);
                textInterface.buyMenu(city, ACRE_PRICE);
                textInterface.sellMenu(city, ACRE_PRICE);
                textInterface.feedMenu(city);
                textInterface.plantMenu(city);
    
                // run turn and get results
                turnResult = city.runTurn();
    
                //show new status
                textInterface.showStatus(city);
    
                //check if win conds apply
                if (turnResult.getYear() == 10) {
                    gameWon = true;
                    break;
                }

                //check if lose conds apply
                if (turnResult.getStarvedPercentage() > 50 || turnResult.getResidents() == 0) {
                    gameWon = false;
                    break;
                }
            }
            System.out.println("Game won? ---> " + gameWon);
        }
        textInterface.close(); //close the scanner inside
    }
}
