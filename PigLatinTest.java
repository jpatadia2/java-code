import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Created by jalpesh on 7/26/2017.
 */
class PigLatinTest {
    @Test
    void vowels() {
        assertEquals("awayway", Piglatin.generatePiglatin(new String[] {"away"}));
    }

    @Test
    void nounds() {
        assertEquals("oinggay", Piglatin.generatePiglatin(new String[]{"going" }));
    }
}