import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Simple piglatin generator of words.
 * Pass in words. Example "java Piglatin jalpesh patadia always eats omelet"
 * Created by jalpesh on 7/16/2017.
 */
public class Piglatin {

    public static void main(String[] args) {
        generatePiglatin(args);
    }

    public static String generatePiglatin(String[] words) {
        List<String> piglatin = new ArrayList<>();
        for(String w : words) {
            String first = Character.toString(w.charAt(0));
            if("aieou".contains(first))
                piglatin.add(w+"way");
            else
                piglatin.add(w.substring(1) + first + "ay");
        }

        String output = piglatin.stream().collect(Collectors.joining(","));
        System.out.println("Original:" + Arrays.stream(words).collect(Collectors.joining(",")));
        System.out.println("Piglatin:" + piglatin.stream().collect(Collectors.joining(",")));

        return output;
    }
}
