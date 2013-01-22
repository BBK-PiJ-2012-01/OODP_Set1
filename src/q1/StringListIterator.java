package q1;

import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * User: Sam Wright
 * Date: 21/01/2013
 * Time: 18:07
 */
public class StringListIterator implements ListIterator<String> {
    private final List<String> lst;
    private String next;
    private String prev;
    private int next_id = -1;
    private int prev_id = -1;
    private OP last_op = OP.NONE;

    private static enum OP {
        NONE, NEXT, PREV, REMOVE, ADD
    }

    public StringListIterator(List<String> lst) {
        this.lst = lst;

        if (!lst.isEmpty()) {
            next = lst.get(0);
            next_id = 0;
        }
    }

    @Override
    public boolean hasNext() {
        return next_id != -1;
    }

    @Override
    public String next() {
        if (hasNext()) {
            last_op = OP.NEXT;

            String result = next;
            prev = next;
            prev_id = next_id++;
            try {
                next = lst.get(next_id);
            } catch (IndexOutOfBoundsException err) {
                next = null;
                next_id = -1;
            }
            return result;
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public boolean hasPrevious() {
        return prev_id != -1;
    }

    @Override
    public String previous() {
        if (hasPrevious()) {
            last_op = OP.PREV;

            String result = prev;
            next = prev;
            next_id = prev_id--;
            try {
                prev = lst.get(prev_id);
            } catch (IndexOutOfBoundsException err) {
                prev = null;
                prev_id = -1;
            }
            return result;
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public int nextIndex() {
        return next_id;
    }

    @Override
    public int previousIndex() {
        return prev_id;
    }

    @Override
    public void remove() {
        if (last_op == OP.NONE) {
            // Neither next() nor prev() have been called
            throw new IllegalStateException();
        } else if (last_op == OP.REMOVE) {
            // Can't remove then remove again
            throw new IllegalStateException();
        } else if (last_op == OP.ADD) {
            // Can't add then remove
            throw new IllegalStateException();
        } else if (last_op == OP.NEXT) {
            // Remove previous element
            lst.remove(prev_id--);

            if (hasNext())
                --next_id;

            try {
                prev = lst.get(prev_id);
            } catch (IndexOutOfBoundsException err) {
                prev_id = -1;
            }
        } else if (last_op == OP.PREV) {
            // Remove next element
            lst.remove(next_id++);

            try {
                next = lst.get(next_id);
            } catch (IndexOutOfBoundsException err) {
                next_id = -1;
            }
        }

        last_op = OP.REMOVE;
    }

    @Override
    public void set(String s) {
        if (last_op == OP.NONE) {
            // Neither next() nor prev() have been called
            throw new IllegalStateException();
        } else if (last_op == OP.REMOVE) {
            // Can't remove then set
            throw new IllegalStateException();
        } else if (last_op == OP.ADD) {
            // Can't add then set
            throw new IllegalStateException();
        } else if (last_op == OP.NEXT) {
            // Set previous element
            lst.set(prev_id, s);
            prev = s;
        } else if (last_op == OP.PREV) {
            // Set next element
            lst.set(next_id, s);
            next = s;
        }
    }

    @Override
    public void add(String s) {
        // Dummy implementation
        // Added value always replaces 'prev'
        lst.add(++prev_id, s);
        if (hasNext())
            next_id++;
        prev = s;
        last_op = OP.ADD;
    }
}
