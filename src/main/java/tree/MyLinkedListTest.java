package tree;

/**
 * Created by sshek8 on 8/25/2016.
 */
public class MyLinkedListTest {

    public static void main(String[] args) {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        System.out.printf(linkedList.toString());
    }
}
