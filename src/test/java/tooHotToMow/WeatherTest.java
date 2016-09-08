package tooHotToMow;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WeatherTest {

    Weather weather;

    @Test
    public void canCalculateAHeatIndex() {
        weather = new Weather(79.0, 60.0);
        Double result = weather.heatIndex();
        assertTrue(result.getClass() == Double.class);
    }

    @Test
    public void heatIndexIsBelow80() {
        weather = new Weather(79.0, 60.0);
        Double result = weather.heatIndex();
        assertEquals(79.42, result, 0.01);
    }

    @Test
    public void heatIndexisAbout88() {
        weather = new Weather(86.0, 50.0);
        Double result = weather.heatIndex();
        assertEquals(87.88, result, 0.01);

    }

    @Test
    public void heatIndexIsAbout87() {
        weather = new Weather(86.0, 45.0);
        Double result = weather.heatIndex();
        assertEquals(86.56, result, 0.01);
    }

    @Test
    public void shouldUseLowRHAdjustment() {
        weather = new Weather(110.0, 12.0);
        Double result = weather.heatIndex();
        assertEquals(105.96, result, 0.01);
    }


}
