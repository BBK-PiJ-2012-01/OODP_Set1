package q3;

import q1.LinkedListRunner;

import java.util.*;

/**
 * User: Sam Wright
 * Date: 22/01/2013
 * Time: 09:44
 */
public class TreeSetRunner {
    public static void main(String[] args) {
        List<String> lst = new LinkedList<String>();
        LinkedListRunner.addAToJ(lst);
        LinkedListRunner.addAToJ(lst);
        Collections.reverse(lst);

        Set<String> set = new TreeSet<String>(lst);

        System.out.print("{ ");
        for (String s : set) {
            System.out.print(s + " ");
        }
        System.out.print("}");

        // 1. Each string appears only once
        // 2. The strings are ordered using 'String.compareTo'
        //    which, for a string, means alphabetically.
    }
}
