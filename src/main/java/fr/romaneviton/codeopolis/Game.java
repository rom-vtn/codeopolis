package fr.romaneviton.codeopolis;

import java.util.Random;

import dev.codeopolis.increment03.TurnResult;

public class Game {
    private TextInterface parent;
    private City city;
    private GameConfig gameConfig;
    private Random random;

    private void runGame() {
        TurnResult turnResult;
        boolean gameWon = false;
        while (true) { //TODO: add quit condition or death condition
            // do interface stuff
            int acrePrice = random.nextInt(gameConfig.getMaxAcrePrice()-gameConfig.getMinAcrePrice()) + gameConfig.getMinAcrePrice();
            parent.showStatus(city);
            parent.buyMenu(city, acrePrice);
            parent.sellMenu(city, acrePrice);
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
        city = new City(parent.askCityName("What's that name of your city? "), gameConfig);
        gameConfig = new GameConfig(DifficultyLevel.EASY);
        random = new Random();
        runGame();
    }
}
