package fr.romaneviton.codeopolis;

public class GameConfig {
    // Initial number of residents:
    private int initialResidents;
    // Initial number of acres
    private int initialAcres;
    // Initial number of bushels:
    private int initialBushels;
    // Maximum price per acre of land:
    private int maxAcrePrice;
    // Minimum price per acre of land:
    private int minArcrPrice;
    // Number of bushels to be fed per resident per year:
    private int bushelsPerResident;
    // Number of bushels to plant per acre:
    private int bushelsPerAcre;
    // Number of acres a resident can farm:
    private int acrePerResident;
    // Number of game turns (years):
    private int numberOfYears;
    // The harvest factor indicates the maximum harvest rate:
    private float harvestFactor;
    // The maximum percentage of bushels rats can eat in a year:
    private int rateInfestation;
    // Difficulty level of the game:
    private DifficultyLevel level;
}

public enum DifficultyLevel {
    EASY, MEDIUM, HARD
}