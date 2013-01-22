package q13;

import java.util.HashSet;
import java.util.Set;

import static util.CollectionsUtil.setOf;

/**
 * User: Sam Wright
 * Date: 22/01/2013
 * Time: 13:31
 */
public class EmployeeRunner {

    public static void main(String[] args) {
        Set<Employee> set = new HashSet<Employee>();

        Employee alice = new Employee(0, "Alice", "345", "Underling");
        Employee bob = new Employee(1, "Bob", "012", "Manager");
        Employee bob_clone = new Employee(1, "Bob", "012", "Manager");

        set.add(alice);
        set.add(bob);
        set.add(bob_clone);

        System.out.println(set);
        assert setOf(alice, bob).equals(set);

    }
}
