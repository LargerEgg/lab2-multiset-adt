
// Node is only used inside the LinkedList class, so we define it in the same file;
// there can only be one public class in a file, but there can also be non-public classes.
class Node {
    int item;
    Node next;
    Node(int item) {
        this.item = item;
    }
}


public class LinkedListMultiSet extends MultiSet {

    // a linked list initially is empty
    private Node front;
    private int size;

    @Override
    public void add(int item) {
        Node newNode =  new Node(item);
        newNode.next = front;
        front = newNode;
        size += 1;
    }

    @Override
    public void remove(int item) {
        Node cur = front;
        Node prev = null;
        while (cur != null) {
            if (cur.item == item) {
                size -= 1;
                if (prev != null) {
                    prev.next = cur.next;
                }
                else {
                    front = cur.next;
                }
                return;
            }
            prev = cur;
            cur = cur.next;
        }
    }

    @Override
    public boolean contains(int item) {
        Node cur = front;
        while (cur != null) {
            if (cur.item == item) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return this.front == null;
    }


    @Override
    public int count(int item) {
        int num_seen = 0;
        Node cur = this.front;
        while (cur != null) {
            if (cur.item == item) {
                num_seen += 1;
            }
            cur = cur.next;
        }
        return num_seen;
    }

    @Override
    public int size() {
        return this.size;
    }
}
