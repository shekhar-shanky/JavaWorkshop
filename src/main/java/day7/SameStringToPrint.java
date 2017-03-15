package day7;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sshek8 on 8/18/2016.
 */
public class SameStringToPrint {

    public static void main(String[] args) {
        String str1 = "abcd";
        String str2 = "fedcba";

        List<Number> list = new ArrayList();
        list.add(new Integer(1));
        list.add(new Double(2.2));


        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < charArray1.length; i++) {
            for (int j = 0; j < charArray2.length; j++) {
                if (charArray1[i] == charArray2[j]) {
                    sb.append(charArray1[i]);
                }
            }
        }

        System.out.println(sb.toString());
    }

}
