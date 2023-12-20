public class City {
    private String name;
    private int bushelCount;
    private int acreCount;
    private int population;
    private int currentBushelSpendingOnFood;
    private int currentUsedAcreCount;
    private int age;

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
        this.currentBushelSpendingOnFood = bushelCount;
        // TODO: adjust city population 
        return true;
    }

    public boolean plant(int acreCount) {
        if (acreCount < 0 || this.acreCount < acreCount || this.bushelCount < acreCount || this.population * 10 < acreCount) {return false;}
        this.bushelCount -= acreCount;
        // TODO add to current bushelCount?
        return true;
    }

    public String toString() {
        String s = "In the year "+age+" after its foundation, the city of "+name+" and its "+population+" inhabitants reign over "+acreCount+" acres of land and own "+bushelCount+" bushels of grain.";
        return s;
    }

    public City(String name) {
        setName(name);
        setBushelCount(2800);
        setAcreCount(1000);
        setPopulation(100);
        
        age = 0;
        currentBushelSpendingOnFood = 0;
        currentUsedAcreCount = 0;
    }
}