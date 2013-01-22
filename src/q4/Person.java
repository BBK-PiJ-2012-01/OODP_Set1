package q4;

/**
 * User: Sam Wright
 * Date: 22/01/2013
 * Time: 09:48
 */
public class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String toString() {
        return "Name: " + firstName + " " + lastName;
    }

    @Override
    public int compareTo(Person that) {
        return this.getLastName().compareTo(that.getLastName());
    }
}
