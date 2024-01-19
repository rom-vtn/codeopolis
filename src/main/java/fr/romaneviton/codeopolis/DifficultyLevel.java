package fr.romaneviton.codeopolis;

public enum DifficultyLevel {
    EASY("easy"), MEDIUM("medium"), HARD("hard");
    private final String s;
    DifficultyLevel(String s) {
        this.s = s;
    }
}
