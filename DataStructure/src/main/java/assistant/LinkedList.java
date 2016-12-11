package assistant;

/**
 * Created by ritesh on 12/16/15.
 */
public class LinkedList<T> {

    public T val;
    public LinkedList next;

    public LinkedList() {

    }

    public LinkedList(T val) {

        this.val = val;
        this.next = null;
    }
}
