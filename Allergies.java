import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * A simple class to test bitwise operators in java
 * Created by jalpesh on 7/16/2017.
 */
public class Allergies {

    public enum ALLERGY {
        EGGS (1),
        PEANUTS (2),
        SHELLFISH (4),
        STRAWBERRIES (8),
        TOMATOES (16),
        CHOCOLATE (32),
        POLLEN (64),
        CATS (256);

        int value;
        ALLERGY(int val) {
            this.value = val;
        }
        public int value() {
            return value;
        }

    }

    public static void main(String[] args) {
        int val = Integer.valueOf(args[0]);

        String allergies = Arrays.stream(ALLERGY.values()).filter(x -> (x.value & val) == x.value).map( x -> x.toString()).collect(Collectors.joining(","));

        System.out.println("Input:" + val + ", ALLERGIES : " + allergies);

    }
}
