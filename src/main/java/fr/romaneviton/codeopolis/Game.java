package fr.romaneviton.codeopolis;

import dev.codeopolis.increment03.TurnResult;

public class Game {
    public static final int ACRE_PRICE = 40;
    private TextInterface parent;
    private City city;

    private void runGame() {
        int ACRE_PRICE = 40; //TODO: make prices variable later
        TurnResult turnResult;
        boolean gameWon = false;
        city = new City(parent.askCityName("What's that name of your city? "));
        while (true) { //TODO: add quit condition or death condition
            // do interface stuff
            parent.showStatus(city);
            parent.buyMenu(city, ACRE_PRICE);
            parent.sellMenu(city, ACRE_PRICE);
            parent.feedMenu(city);
            parent.plantMenu(city);

            // run turn and get results
            turnResult = city.runTurn();

            //show new status
            parent.showStatus(city);

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

    public Game(TextInterface parent) {
        this.parent = parent;
        runGame();
    }
}
