package q1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * User: Sam Wright
 * Date: 17/01/2013
 * Time: 14:47
 */
public class LinkedListRunner {
    static private final List<Character> vowels = new LinkedList<Character>(Arrays.asList(new Character[]{'a', 'e', 'i', 'o', 'u'}));

    public static void main(String[] args) {
        List<String> lst = new LinkedList<String>();

        addAToJ(lst);

        StringListIterator itr = new StringListIterator(lst);
        printForwards(itr);

        while (itr.hasPrevious()) {
            String item = itr.previous();
            if (vowels.contains(item.charAt(0)))
                itr.remove();
        }

        printForwards(itr);

    }

    private static void printForwards(StringListIterator itr) {
        System.out.print("[ ");
        while (itr.hasNext()) {
            String item = itr.next();
            System.out.print(item + " ");
        }
        System.out.println("]");
    }

    public static void addAToJ(List<String> lst) {
        for (char c = 'a'; c < 'j'; ++c) {
            // Build string
            StringBuilder sbuild = new StringBuilder();
            for (int i = 0; i < 3; ++i) {
                sbuild.append(c);
            }

            // Add string to list
            lst.add(sbuild.toString());
        }
    }
}
