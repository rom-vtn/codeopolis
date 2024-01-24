package fr.romaneviton.codeopolis.domainmodel;

import java.util.Random;

public class Game {
    private UserInterface userInterface;
    private City city;
    private GameConfig gameConfig;
    private Random random;

    private void runGame() {
        TurnResult turnResult;
        boolean gameWon = false;
        int inputValue;
        while (true) {
            // do interface stuff
            int acrePrice = random.nextInt(gameConfig.getMaxAcrePrice()-gameConfig.getMinAcrePrice()) + gameConfig.getMinAcrePrice();
            //userInterface.showStatus(city);
            
            // userInterface.buyMenu(city, acrePrice);
            while (true) {
                inputValue = userInterface.buy(acrePrice, city);
                if (city.buy(inputValue, acrePrice)) {
                    break;
                } else {
                    userInterface.illegalInput("Can't buy this!");
                }
            }

            //userInterface.sellMenu(city, acrePrice);
            while (true) {
                inputValue = userInterface.sell(acrePrice, city);
                if (city.sell(inputValue, acrePrice)) {
                    break;
                } else {
                    userInterface.illegalInput("Can't sell this!");
                }
            }
            
            //userInterface.feedMenu(city);
            while (true) {
                //NOTE: spec says ui.feed must return the number of *residents* fed, not the bushels
                //FIXME change TextInterface's return value accordingly
                inputValue = userInterface.feed(gameConfig.getBushelsPerResident(), city);
                //multiply to fix this
                if (city.feed(inputValue * gameConfig.getBushelsPerResident())) {
                    break;
                } else {
                    userInterface.illegalInput("Can't feed this!");
                }
            }
            
            //userInterface.plantMenu(city);
            while (true) {
                inputValue = userInterface.plant(gameConfig.getBushelsPerAcre(), gameConfig.getAcrePerResident(), city);
                if (city.plant(inputValue)) {
                    break;
                } else {
                    userInterface.illegalInput("Can't plant this!");
                }
            }

            // run turn and get results
            turnResult = city.runTurn();

            //show new status
            //userInterface.showStatus(city);
            userInterface.turnEnd(turnResult);

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
        if (gameWon) {
            userInterface.gameWon("Congration! You done it");
        } else {
            userInterface.gameLost("Looks like our monarch did a fatal oopsie and got dethroned");
        }
    }

    public Game(UserInterface parent) {
        this.userInterface = parent;
        //gameConfig = new GameConfig(parent.askDifficultyLevel());
        //city = new City(parent.askCityName("What's that name of your city? "), gameConfig);
        //TODO actually ask difficulty level and city name once we're done debugging
        gameConfig = new GameConfig(DifficultyLevel.MEDIUM);
        city = new City("Codeopolis", gameConfig);
        random = new Random();
        runGame();
    }
}
