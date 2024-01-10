package fr.romaneviton.codeopolis;

import City

public class CityTestDrive {
    public static void main(String[] args) {
        City c = new City("Saarbrücken 2");
        System.out.println(c);

        //Test getters and default values
        assertEquals("Name", "Saarbrücken 2", c.getName());

        assertEquals("bushelCount", 2800, c.getBushelCount());

        assertEquals("acreCount", 1000, c.getAcreCount());

        assertEquals("population", 100, c.getPopulation());

        assertEquals("age", 0, c.getAge());

        //Test setters and values

    }

    public static void assertEquals(String description, int expected, int actual) {
        System.out.println(((expected==actual)?"[PASS] ":"[FAIL] ") + description);
    }

    public static void assertEquals(String description, String expected, String actual) {
        System.out.println(((expected.equals(actual))?"[PASS] ":"[FAIL] ") + description);
    }

    public static void assertEquals(String description, boolean expected, boolean actual) {
        System.out.println(((expected==actual)?"[PASS] ":"[FAIL] ") + description);
    }


}
