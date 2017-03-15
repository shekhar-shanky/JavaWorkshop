package day9;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by sshek8 on 8/23/2016.
 */
@Retention(RetentionPolicy.CLASS)
public @interface ABC {
    String abc();

    int i();
}


@ABC(abc = "a", i = 0)
class A1 {

}