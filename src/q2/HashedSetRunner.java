package q2;

import q1.LinkedListRunner;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * User: Sam Wright
 * Date: 22/01/2013
 * Time: 09:34
 */
public class HashedSetRunner {

    public static void main(String... args) {
        List<String> lst = new LinkedList<String>();
        LinkedListRunner.addAToJ(lst);
        LinkedListRunner.addAToJ(lst);

        Set<String> set = new HashSet<String>(lst);

        System.out.print("{ ");
        for (String s : set) {
            System.out.print(s + " ");
        }
        System.out.print("}");

        // 1. Each string appears only once in the HashSet
        // 2. The order of the strings is not maintained
        //      (probably ordered by hashCode instead)
    }
}
