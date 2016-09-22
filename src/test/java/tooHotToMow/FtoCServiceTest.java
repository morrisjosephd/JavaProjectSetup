package tooHotToMow;


import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class FtoCServiceTest {

    @Test
    public void convertsFToCForBoiling() {
        Double result = FtoCService.convert(212.0);
        assertEquals(100.0, result, 0.1);
    }

    @Test
    public void convertsFToCForFreezing() {
        Double result = FtoCService.convert(32.0);
        assertEquals(0.0, result, 0.1);
    }
}
