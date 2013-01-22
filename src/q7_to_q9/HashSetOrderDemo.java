package q7_to_q9;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * User: Sam Wright
 * Date: 22/01/2013
 * Time: 10:35
 */
public class HashSetOrderDemo {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();

        for (char c = 'a'; c < 'k'; ++c) {
            String str = "";
            for (int i = 0; i < 3; ++i) {
                str += c;
                set.add(str);
            }
        }

        Iterator itr = set.iterator();
        System.out.print("{ ");
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println("}");

        // Entry sequence = [ a, aa, aaa, b, bb, bbb, c, ...]
        // Iterator output sequence = {ddd, hh, iii, jj, bbb ,...]

        // Different because a HashSet's ordering is based on the hashCodes
        // of its member objects, not using the 'String.compareTo' method.

        // q8. Adding using a ListIterator implies adding just before the iterator's
        // virtual location in the collection.  However, a set cannot be added to at
        // a certain location (as this is determined by the new element's hashCode).

        // q9. Iterator doesn't contain a previous method (like ListIterator does)
        // and this is sensible for iterating through the HashSet due to its underlying
        // structure of an array of linked lists.  Being able only to go forwards means
        // iterating through the array, then iterating through each linked list.
        // Each linked list is accessed once, and each element will be followed by
        // the next in the linked list.  If the iterator could go backwards it might need
        // to access the linked lists more than once, and each element must be able to
        // give both the next and previous elements.

    }
}