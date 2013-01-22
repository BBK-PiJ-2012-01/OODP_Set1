package q10;

import java.util.*;

/**
 * User: Sam Wright
 * Date: 22/01/2013
 * Time: 12:00
 */
public class SetDuplicateDemo {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> elements = new HashSet<Integer>();

        // Explicitly add only unique values to elements,
        // and add all elements (including duplicates) to set
        for (int i = 1; i < 200; ++i) {
            int element = (int) (Math.abs(Math.random()) * ( i % 20 ));
            System.out.println(element);
            if (!elements.contains(element)) {
                elements.add(element);
            }
            set.add(element);
        }

        // Assert elements and set are equal
        assert set.equals(elements);

        // Make sure you can't add null twice.
        set.add(null);
        set.add(null);
        assert setOf(null).equals(set);
    }

    private static <T> Set<T> setOf(T... contents) {
        return new HashSet<T>(Arrays.asList(contents));
    }
}
