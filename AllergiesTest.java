import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Created by jalpesh on 7/26/2017.
 */
class AllergiesTest {
    @Test
    void eggPeanuts() {
        assertEquals("EGGS,PEANUTS", Allergies.getAllergy(3));
    }

    @Test
    void cats() {
        assertEquals("CATS" , Allergies.getAllergy(128));
    }

    @Test
    void invalid() {
        assertEquals("" , Allergies.getAllergy(-1 ));
    }

    @Test
    void outOfBounds() {
        assertEquals("EGGS" , Allergies.getAllergy(256 ));
    }

    @Test
    void allOfThem() {
        assertEquals("EGGS,PEANUTS,SHELLFISH,STRAWBERRIES,TOMATOES,CHOCOLATE,POLLEN,CATS" , Allergies.getAllergy(255 ));
    }
}