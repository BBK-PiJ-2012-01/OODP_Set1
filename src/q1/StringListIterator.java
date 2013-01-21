package q1;

import java.util.List;
import java.util.ListIterator;

/**
 * User: Sam Wright
 * Date: 21/01/2013
 * Time: 18:07
 */
public class StringListIterator implements ListIterator<String> {
    private final List<String> lst;

    public StringListIterator(List<String> lst) {
        this.lst = lst;
    }

    @Override
    public boolean hasNext() {
        return false; // Dummy implementation
    }

    @Override
    public String next() {
        return null; // Dummy implementation
    }

    @Override
    public boolean hasPrevious() {
        return false; // Dummy implementation
    }

    @Override
    public String previous() {
        return null; // Dummy implementation
    }

    @Override
    public int nextIndex() {
        return 0; // Dummy implementation
    }

    @Override
    public int previousIndex() {
        return 0; // Dummy implementation
    }

    @Override
    public void remove() {
        // Dummy implementation
    }

    @Override
    public void set(String s) {
        // Dummy implementation
    }

    @Override
    public void add(String s) {
        // Dummy implementation
    }
}
