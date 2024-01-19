package fr.romaneviton.codeopolis;

public class Codeopolis {
    public static void main(String[] args) {
        TextInterface textInterface = new TextInterface();
        Game game;
        while (textInterface.mainMenu() != TextInterface.MainMenuOptions.QUIT) {
            game = new Game(textInterface);
        }
        textInterface.close(); //close the scanner inside
    }
}
