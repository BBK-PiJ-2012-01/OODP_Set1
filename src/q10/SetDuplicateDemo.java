package q10;

import java.util.*;

import static util.CollectionsUtil.setOf;

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
        Set<Integer> null_containing_set = new HashSet<Integer>();
        null_containing_set.add(null);
        assert null_containing_set.equals(set);
    }
}
