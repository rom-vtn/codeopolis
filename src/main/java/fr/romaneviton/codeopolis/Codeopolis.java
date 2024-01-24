package fr.romaneviton.codeopolis;

import fr.romaneviton.codeopolis.domainmodel.Game;
import fr.romaneviton.codeopolis.presentation.TextInterface;


public class Codeopolis {
    public static void main(String[] args) {
        TextInterface textInterface = new TextInterface();
        while (textInterface.mainMenu() != TextInterface.MainMenuOptions.QUIT) {
            new Game(textInterface);
        }
        textInterface.close(); //close the scanner inside
    }
}
