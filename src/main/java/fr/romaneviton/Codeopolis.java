package fr.romaneviton;

public class Codeopolis {
    public static void main(String[] args) {
        int ACRE_PRICE = 40; //TODO: make prices variable later
        TextInterface textInterface = new TextInterface();
        City city = new City(textInterface.askCityName());
        while (textInterface.mainMenu() != TextInterface.MainMenuOptions.QUIT) {
            //Main menu
            TextInterface.GameMenuOptions gameMenuOption = textInterface.gameMenu();
            while (gameMenuOption != TextInterface.GameMenuOptions.QUIT) {
                switch (gameMenuOption) {
                    case BUY:
                        textInterface.buyMenu(city, ACRE_PRICE);
                        break;
                    case SELL:
                        textInterface.sellMenu(city, ACRE_PRICE);
                        break;
                    case FEED:
                        textInterface.feedMenu(city);
                        break;
                    case PLANT:
                        textInterface.plantMenu(city);
                        break;
                    case SHOW_STATUS:
                        textInterface.showStatus(city);
                        break; 
                    default:
                        //this should never be run
                        break;
                }
                gameMenuOption = textInterface.gameMenu();
            }
        }
        textInterface.close(); //close the scanner inside
    }
}
