package q14;

import java.util.PriorityQueue;

/**
 * User: Sam Wright
 * Date: 22/01/2013
 * Time: 13:45
 */
public class PriorityQueueRunner {
    public static void main(String[] args) {
        PriorityQueue<Person> q = new PriorityQueue<Person>();

        q.add(new Person("Sam","Smith"));
        q.add(new Person("Charlie", "Black"));
        q.add(new Person("Betty", "Brown"));
        q.add(new Person("Jessica", "Stewart"));
        q.add(new Person("John", "Friday"));
        q.add(new Person("Frank", "Foley"));

        while (!q.isEmpty()) {
            System.out.println(q.poll());
        }

        // Printed in order of 'priority' (ie. the 'smallest' of the
        // given objects pushes its way to the front of the queue,
        // and the 'largest' stays at the back.
    }
}
