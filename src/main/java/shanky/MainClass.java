package shanky;

/**
 * Created by sshek8 on 2/24/2017.
 */

interface Fish {
}

class B {
}

class Blue {
}

public class MainClass {
    public static void main(String[] args) {
        Blue b = new Blue();
        if (b instanceof Fish) {
            System.out.println("00");
        }

//        if(b instanceof String){
//            System.out.println("ppp");
//        }

    }

}
