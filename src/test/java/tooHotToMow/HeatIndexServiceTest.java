package tooHotToMow;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HeatIndexServiceTest {

    HeatIndexService heatIndexService;

    @Test
    public void canCalculateAHeatIndex() {
        heatIndexService = new HeatIndexService(79.0, 60.0);
        Double result = heatIndexService.heatIndex();
        assertTrue(result.getClass() == Double.class);
    }

    @Test
    public void heatIndexIsBelow80() {
        heatIndexService = new HeatIndexService(79.0, 60.0);
        Double result = heatIndexService.heatIndex();
        assertEquals(79.42, result, 0.01);
    }

    @Test
    public void heatIndexisAbout88() {
        heatIndexService = new HeatIndexService(86.0, 50.0);
        Double result = heatIndexService.heatIndex();
        assertEquals(87.88, result, 0.01);

    }

    @Test
    public void heatIndexIsAbout87() {
        heatIndexService = new HeatIndexService(86.0, 45.0);
        Double result = heatIndexService.heatIndex();
        assertEquals(86.56, result, 0.01);
    }

    @Test
    public void shouldUseLowRHAdjustment() {
        heatIndexService = new HeatIndexService(110.0, 12.0);
        Double result = heatIndexService.heatIndex();
        assertEquals(105.79, result, 0.01);
    }

    @Test
    public void shouldAdjustForHighRH() {
        heatIndexService = new HeatIndexService(82.0, 90.0);
        Double result = heatIndexService.heatIndex();
        assertEquals(92.00, result, 0.01);
    }

}
