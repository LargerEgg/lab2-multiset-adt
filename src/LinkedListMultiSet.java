
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


    public void add(int item) {
        Node newNode =  new Node(item);
        newNode.next = front;
        front = newNode;
        size += 1;
    }

    public void remove(int item) {
        Node cur = this.front;
        Node prev = null;
        while (cur.next != null) {
            if (cur.next.item == item) {
                this.size -= 1;
                if (prev != null) {
                    prev.next = cur.next;
                } else {
                    this.front = cur.next;
                }
            }
            Node tmp = cur;
            prev = cur;
            cur = cur.next;

        }
    }

    public boolean contains(int item) {
        return false;
    }

    public boolean isEmpty() {
        return false;
    }


    public int count(int item) {
        return -1;
    }

    public int size() {
        return -1;
    }
}
