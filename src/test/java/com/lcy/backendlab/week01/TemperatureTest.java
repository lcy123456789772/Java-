package com.lcy.backendlab.week01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TemperatureTest {

    @Test
    void convertsFreezingPoint() {
        assertEquals(32.0, Temperature.toFahrenheit(0), 0.0001);
    }

    @Test
    void convertsBoilingPoint() {
        assertEquals(212.0, Temperature.toFahrenheit(100), 0.0001);
    }

    @Test
    void convertsNegativeForty() {
        assertEquals(-40.0, Temperature.toFahrenheit(-40), 0.0001);
    }

    @Test
    void createsTableFromZeroToTen() {
        String expected = """
                0C = 32F
                1C = 34F
                2C = 36F
                3C = 37F
                4C = 39F
                5C = 41F
                6C = 43F
                7C = 45F
                8C = 46F
                9C = 48F
                10C = 50F
                """;
        assertEquals(expected, Temperature.table(0, 10));
    }

    @Test
    void createsSingleRowTable() {
        assertEquals("20C = 68F\n", Temperature.table(20, 20));
    }
}
