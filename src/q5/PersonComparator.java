package q5;

import java.util.Comparator;

/**
 * User: Sam Wright
 * Date: 22/01/2013
 * Time: 09:59
 */
public class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getLastName().compareTo(o2.getLastName());
    }
}
