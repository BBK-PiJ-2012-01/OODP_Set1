package q6;

import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * User: Sam Wright
 * Date: 22/01/2013
 * Time: 10:24
 */
public class HashSetDemo {
    public static void main(String[] args) {
        // Set is the interface, HashSet is the implementation.
        // It is common to declare a variable as the interface
        // (eg. Set<String> names) because when it comes to using
        // names, we don't care about how the Set was implemented.

        Set<String> names1 = new HashSet<String>(Arrays.asList(new String[]{"a","b","c"}));
        Set<String> names2 = new HashSet<String>(Arrays.asList(new String[]{"c", "d", "e"}));
        names1.addAll(names2);

        // HashSet.addAll is inherited from AbstractCollection
        assert names1 instanceof AbstractCollection;
    }
}
