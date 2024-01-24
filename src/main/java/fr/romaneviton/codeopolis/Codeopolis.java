package fr.romaneviton.codeopolis;

public class Codeopolis {
    public static void main(String[] args) {
        TextInterface textInterface = new TextInterface();
        while (textInterface.mainMenu() != TextInterface.MainMenuOptions.QUIT) {
            new Game(textInterface);
        }
        textInterface.close(); //close the scanner inside
    }
}
