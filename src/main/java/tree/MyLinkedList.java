package tree;

/**
 * Created by sshek8 on 8/24/2016.
 */
public class MyLinkedList<E> {

    Node<E> node;

    public MyLinkedList() {

    }

    public void add(E item) {
        if (node == null) {
            node = new Node<>(item, null);
        } else {
            node.next = new Node<>(item, null);
        }
    }

    @Override
    public String toString() {
        return "\nMyLinkedList{" +
                "node=" + node +
                '}';
    }
}

class Node<E> {
    E item;
    Node<E> next;

    public Node(E item, Node<E> next) {
        this.item = item;
        this.next = next;
    }

    @Override
    public String toString() {
        return "\nNode{" +
                "item=" + item +
                ", next=" + next +
                '}';
    }
}
