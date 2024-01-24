package fr.romaneviton.codeopolis.domainmodel;

import java.util.Random;

public class Game {
    private UserInterface parent;
    private City city;
    private GameConfig gameConfig;
    private Random random;

    private void runGame() {
        TurnResult turnResult;
        boolean gameWon = false;
        while (true) {
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
            if (turnResult.getYear() == gameConfig.getNumberOfYears()) {
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

    public Game(UserInterface parent) {
        this.parent = parent;
        gameConfig = new GameConfig(parent.askDifficultyLevel());
        city = new City(parent.askCityName("What's that name of your city? "), gameConfig);
        random = new Random();
        runGame();
    }
}
