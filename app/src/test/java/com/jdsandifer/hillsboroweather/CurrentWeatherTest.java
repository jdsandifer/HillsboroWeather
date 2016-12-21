/*
 * Created by J.D. Sandifer on 12/21/16.
 */

package com.jdsandifer.hillsboroweather;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CurrentWeatherTest {
    CurrentWeather weatherObject;

    @Before
    public void setUp() {
        this.weatherObject = new CurrentWeather();
    }

    @Test
    public void isTestingWorking() {
        assertEquals(1, 1);
        assertNotEquals(0, 1);
    }

    @Test
    public void timeCanBeSetAndReturned() {
        long exampleTime = 123456;

        weatherObject.setTime(exampleTime);

        assertEquals("Correct time wasn't returned.", exampleTime, weatherObject.getTime());
    }

    @Test
    public void humidityCanBeSetAndReturned() {
        double exampleHumidity = 55.0;
        double doubleFuzzFactor = 0.0;

        weatherObject.setHumidity(exampleHumidity);

        assertEquals("Humidity returned doesn't match value set.",
                exampleHumidity,
                weatherObject.getHumidity(),
                doubleFuzzFactor);
    }

    @After
    public void tearDown() {
        this.weatherObject = null;
    }


}
