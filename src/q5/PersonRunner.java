package q5;

import java.util.TreeSet;

/**
 * User: Sam Wright
 * Date: 22/01/2013
 * Time: 09:49
 */
public class PersonRunner {
    public static void main(String[] args) {
        TreeSet<Person> mySet = new TreeSet<Person>(new PersonComparator());
        mySet.add(new Person("Sally", "Brown"));
        mySet.add(new Person("Fred", "Kelly"));
        mySet.add(new Person("Bill", "Akins"));
        mySet.add(new Person("Julie", "Wilkins"));
        mySet.add(new Person("James", "Langdon"));
        for (Person p : mySet) {
            System.out.println(p);
        }

        // Used comparator
    }
}
