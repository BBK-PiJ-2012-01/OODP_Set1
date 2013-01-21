package q1;

import java.util.LinkedList;
import java.util.List;

/**
 * User: Sam Wright
 * Date: 17/01/2013
 * Time: 14:47
 */
public class LinkedListRunner {

    public static void main(String[] args) {
        List<String> lst = new LinkedList<String>();

        for (char c = 'a'; c < 'j'; ++c) {
            // Build string
            StringBuilder sbuild = new StringBuilder();
            for (int i = 0; i < 3; ++i) {
                sbuild.append(c);
            }

            // Add string to list
            lst.add(sbuild.toString());
        }

        System.out.println(lst);

    }
}
