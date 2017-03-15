package day2;

/**
 * Created by sshek8 on 8/10/2016.
 */
public class InternDemo {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = s1;
        String s3 = new String("Hello");
        String s4 = "lo";

        System.out.println("s1 == \"Hello\" --> " + (s1 == "Hello")); //true
        System.out.println("s1 == s2 --> " + (s1 == s2)); //true
        System.out.println("s1 == s3 --> " + (s1 == s3)); //false

        //Strings computed by concatenation at
        //run-time are newly created and therefore distinct.
        System.out.println("Hello\" == \"Hel\" + s4 --> " + ("Hello" == "Hel" + s4)); //flase

        //s3 is not literal, so distinct
        System.out.println("s3 == (\"Hel\" + s4).intern() --> " + (s3 == ("Hel" + s4).intern())); //false

        //The result of explicitly interning a computed string is the same
        //string as any pre-existing literal string with the same contents.
        System.out.println("s1 == s3.intern() --> " + (s1 == s3.intern())); //true
        System.out.println("Hello\" == (\"Hel\" + s4).intern() --> " + ("Hello" == ("Hel" + s4).intern())); //true
        System.out.println("s1 == (\"Hel\" + s4).intern() --> " + (s1 == ("Hel" + s4).intern())); //true
        System.out.println("s3.intern() == (\"Hel\" + s4).intern() --> " + (s3.intern() == ("Hel" + s4).intern())); //true
    }
}