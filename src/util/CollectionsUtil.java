package util;

import java.util.*;

/**
 * User: Sam Wright
 * Date: 22/01/2013
 * Time: 13:35
 */
public class CollectionsUtil {
    public static <T> List<T> listOf(T... contents) {
        return new LinkedList<T>(Arrays.asList(contents));
    }

    public static <T> Set<T> setOf(T... contents) {
        return new HashSet<T>(Arrays.asList(contents));
    }
}
