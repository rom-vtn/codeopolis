package fr.romaneviton.codeopolis;

import java.util.Random;

import dev.codeopolis.increment03.TurnResult;

public class City {
    private String name;
    private int bushelCount;
    private int acreCount;
    private int population;
    private int currentBushelSpendingOnFood;
    private int currentUsedAcreCount;
    private int age;
    private Random random;
    private GameConfig gameConfig;

    public String getName() {
        return name;
    }

    public int getBushelCount() {
        return bushelCount;
    }

    public int getAcreCount() {
        return acreCount;
    }

    public int getPopulation() {
        return population;
    }

    public int getCurrentBushelSpendingOnFood() {
        return currentBushelSpendingOnFood;
    }

    public int getCurrentUsedAcreCount() {
        return currentUsedAcreCount;
    }

    public int getAge() {
        return age;
    }

    public boolean setName(String name) {
        if (name == null) {return false;}
        this.name = name;
        return true;
    }

    public boolean setBushelCount(int bushelCount) {
        if (bushelCount < 0) {return false;}
        this.bushelCount = bushelCount;
        return true;
    }

    public boolean setAcreCount(int acreCount) {
        if (acreCount < 0) {return false;}
        this.acreCount = acreCount;
        return true;
    }

    public boolean setPopulation(int population) {
        if (population < 0) {return false;}
        this.population = population;
        return true;
    }


    public boolean buy(int acreCount, int acrePrice) {
        if (bushelCount < acreCount * acrePrice || acreCount < 0 || acrePrice < 0) {return false;}
        this.acreCount += acreCount;
        this.bushelCount -= acreCount * acrePrice;
        return true;
    }

    public boolean sell(int acreCount, int acrePrice) {
        if (this.acreCount < acreCount || acreCount < 0 || acrePrice < 0) {return false;}
        this.acreCount -= acreCount;
        this.bushelCount += acreCount * acrePrice;
        return true;
    }

    public boolean feed(int bushelCount) {
        if (this.bushelCount < bushelCount || bushelCount < 0) {return false;}
        this.bushelCount -= bushelCount;
        currentBushelSpendingOnFood = bushelCount;
        return true;
    }

    public boolean plant(int acreCount) {
        if (acreCount < 0 || this.acreCount < acreCount || this.bushelCount * gameConfig.getBushelsPerAcre() < acreCount || this.population * gameConfig.getAcrePerResident() < acreCount) {return false;}
        this.bushelCount -= acreCount;
        currentUsedAcreCount = acreCount; 
        return true;
    }

    public TurnResult runTurn() {
        int initialPopulation = population;
        int initialBushelCount = bushelCount;

        //step1 Do hunger stuff
        int bushelDeficit = (gameConfig.getBushelsPerResident() * population) - currentBushelSpendingOnFood;
        int starvedCount, starvedPercentage;
        if (bushelDeficit > 0) {
            starvedCount = Math.round(bushelDeficit / gameConfig.getBushelsPerResident());
            starvedPercentage = Math.round(starvedCount * 100 / population);
        } else {
            starvedCount = 0;
            starvedPercentage = 0;
        }
        population -= starvedCount;
        
        //step2 Do new inhabitants stuff
        int newResidents = 0;
        if (starvedPercentage < 40) {
            newResidents = (int) Math.round(random.nextDouble(0.0, 0.4) * initialPopulation);
            population += newResidents;
        }

        //step3 harvest
        double harvestRate = random.nextDouble(0.1, 1) * gameConfig.getHarvestFactor();
        int bushelsHarvested = (int) Math.round(harvestRate * currentUsedAcreCount);
        bushelCount += bushelsHarvested;

        //step4 rat stuff
        int ateByRats = (int) Math.round(random.nextDouble(0, ((float)gameConfig.getRateInfestation()/100)) * initialBushelCount);
        bushelCount -= ateByRats;

        //step5 add to year
        age++;

        TurnResult tr = new TurnResult(name, age, newResidents, bushelsHarvested, population, bushelCount, starvedCount, acreCount, ateByRats, starvedPercentage);
        return tr;
    }

    public String toString() {
        String s = "In the year "+age+" following its foundation, the city of "+name+" and its "+population+" inhabitants reign over "+acreCount+" acres of land and own "+bushelCount+" bushels of grain.";
        return s;
    }

    public City(String name, GameConfig gameConfig) {
        setName(name);
        setBushelCount(gameConfig.getInitialBushels());
        setAcreCount(gameConfig.getInitialAcres());
        setPopulation(gameConfig.getInitialResidents());
        
        this.gameConfig = gameConfig;
        random = new Random();
        age = 0;
        currentBushelSpendingOnFood = 0;
        currentUsedAcreCount = 0;
    }
}