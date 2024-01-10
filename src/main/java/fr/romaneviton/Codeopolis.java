package fr.romaneviton;

public class Codeopolis {
    public static void main(String[] args) {
        int ACRE_PRICE = 40; //TODO: make prices variable later
        TextInterface textInterface = new TextInterface();
        City city = new City("Saarbrücken 2");
        while (textInterface.mainMenu() != TextInterface.MainMenuOptions.QUIT) {
            
        }
        textInterface.close(); //close the scanner inside
    }
}
