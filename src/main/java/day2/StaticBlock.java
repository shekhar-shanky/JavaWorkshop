package day2;

/**
 * Created by sshek8 on 8/10/2016.
 */
public class StaticBlock {

    static {
        System.out.println("Shashank");
    }

    public static void main(String[] args) {
        System.out.println(XTZ.i);
    }
}

class XTZ {
    static int i = 9;

    static {
        System.out.print("Manik !");
        i = 11;
    }

    int j = 10;

    {
        System.out.println("Sdjdsa");
        System.out.println("j j j j ");

    }


    public XTZ(int a) {
        System.out.println("Constructor");
        j = a;
        i = 22;

    }
}