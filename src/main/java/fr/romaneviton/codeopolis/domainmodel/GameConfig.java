package fr.romaneviton.codeopolis.domainmodel;

public class GameConfig {
    // Initial number of residents:
    private int initialResidents;
    public int getInitialResidents() {
        return initialResidents;
    }
    // Initial number of acres
    private int initialAcres;
    public int getInitialAcres() {
        return initialAcres;
    }
    // Initial number of bushels:
    private int initialBushels;
    public int getInitialBushels() {
        return initialBushels;
    }
    // Maximum price per acre of land:
    private int maxAcrePrice;
    public int getMaxAcrePrice() {
        return maxAcrePrice;
    }
    // Minimum price per acre of land:
    private int minArcrPrice;
    public int getMinAcrePrice() {
        return minArcrPrice;
    }
    // Number of bushels to be fed per resident per year:
    private int bushelsPerResident;
    public int getBushelsPerResident() {
        return bushelsPerResident;
    }
    // Number of bushels to plant per acre:
    private int bushelsPerAcre;
    public int getBushelsPerAcre() {
        return bushelsPerAcre;
    }
    // Number of acres a resident can farm:
    private int acrePerResident;
    public int getAcrePerResident() {
        return acrePerResident;
    }
    // Number of game turns (years):
    private int numberOfYears;
    public int getNumberOfYears() {
        return numberOfYears;
    }
    // The harvest factor indicates the maximum harvest rate:
    private float harvestFactor;
    public float getHarvestFactor() {
        return harvestFactor;
    }
    // The maximum percentage of bushels rats can eat in a year:
    private int rateInfestation;
    public int getRateInfestation() {
        return rateInfestation;
    }
    // Difficulty level of the game:
    private DifficultyLevel level;
    public DifficultyLevel getLevel() {
        return level;
    }

    public GameConfig(DifficultyLevel difficultyLevel) {
        switch (difficultyLevel) {
            case EASY:
                initialResidents = 100;
                initialAcres = 1000;
                initialBushels = 2800;
                maxAcrePrice = 30;
                minArcrPrice = 10;
                bushelsPerResident = 20;
                bushelsPerAcre = 1;
                acrePerResident = 10;
                numberOfYears = 10;
                harvestFactor = 6.0f;
                rateInfestation = 10;
                break;
            case MEDIUM:
                initialResidents = 100;
                initialAcres = 900;
                initialBushels = 2800;
                maxAcrePrice = 35;
                minArcrPrice = 15;
                bushelsPerResident = 22;
                bushelsPerAcre = 1;
                acrePerResident = 10;
                numberOfYears = 10;
                harvestFactor = 5.0f;
                rateInfestation = 20;
                break;
            case HARD:
                initialResidents = 100;
                initialAcres = 800;
                initialBushels = 2800;
                maxAcrePrice = 35;
                minArcrPrice = 15;
                bushelsPerResident = 24;
                bushelsPerAcre = 1;
                acrePerResident = 10;
                numberOfYears = 10;
                harvestFactor = 4.0f;
                rateInfestation = 25;
                break;
        }
    }
}