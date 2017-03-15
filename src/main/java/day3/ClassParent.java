package day3;

/**
 * Created by sshek8 on 8/11/2016.
 */
public class ClassParent {

    int x = getInt();

    public static void main(String[] args) {
        ClassParent obj = new ClassChild();
        System.out.println(obj.x);
    }

    private int getInt() {
        return 7;
    }
}

class ClassChild extends ClassParent {

    int y = 8;

    public ClassChild() {
        this.y = 100;
    }

    public int getInt() {
        return y;
    }
}
