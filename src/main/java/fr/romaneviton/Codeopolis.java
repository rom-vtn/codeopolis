package fr.romaneviton;

public class Codeopolis {
    public static void main(String[] args) {
        int ACRE_PRICE = 40; //TODO: make prices variable later
        TextInterface textInterface = new TextInterface();
        City city = new City(textInterface.askCityName("What's that name of your city? "));
        // while (textInterface.mainMenu() != TextInterface.MainMenuOptions.QUIT) {
        //     //Main menu
        //     TextInterface.GameMenuOptions gameMenuOption = textInterface.gameMenu();
        //     while (gameMenuOption != TextInterface.GameMenuOptions.QUIT) {
        //         switch (gameMenuOption) {
        //             case BUY:
        //                 textInterface.buyMenu(city, ACRE_PRICE);
        //                 break;
        //             case SELL:
        //                 textInterface.sellMenu(city, ACRE_PRICE);
        //                 break;
        //             case FEED:
        //                 textInterface.feedMenu(city);
        //                 break;
        //             case PLANT:
        //                 textInterface.plantMenu(city);
        //                 break;
        //             case SHOW_STATUS:
        //                 textInterface.showStatus(city);
        //                 break; 
        //             default:
        //                 //this should never be run
        //                 break;
        //         }
        //         gameMenuOption = textInterface.gameMenu();
        //     }

        // }
        boolean survived = true;
        while (survived) { //TODO: add quit condition or death condition
            textInterface.showStatus(city);
            textInterface.buyMenu(city, ACRE_PRICE);
            textInterface.sellMenu(city, ACRE_PRICE);
            textInterface.feedMenu(city);
            textInterface.plantMenu(city);

            survived = city.runTurn();
        } 
        textInterface.close(); //close the scanner inside
    }
}
