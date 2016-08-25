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




}
