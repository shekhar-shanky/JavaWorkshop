package creational;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by sshek8 on 2/27/2017.
 */
public class MySingletonTest {

    public static void main(String[] args) {


        //with timestamp
//        Calendar calendar1= new GregorianCalendar(2013,1,28,13,24,56);

        Calendar c1 = new GregorianCalendar(2004, 7, 31);
        Calendar c2 = new GregorianCalendar(2004, 1, 1);


        int year1 = c1.get(Calendar.YEAR);
        int month1 = c1.get(Calendar.MONTH); // Jan = 0, dec = 11
        int dayOfMonth1 = c1.get(Calendar.DAY_OF_MONTH);

        System.out.println("year \t\t: " + year1);
        System.out.println("month \t\t: " + month1);
        System.out.println("dayOfMonth \t: " + dayOfMonth1);

        int year2 = c2.get(Calendar.YEAR);
        int month2 = c2.get(Calendar.MONTH); // Jan = 0, dec = 11
        int dayOfMonth2 = c2.get(Calendar.DAY_OF_MONTH);

        System.out.println("year \t\t: " + year2);
        System.out.println("month \t\t: " + month2);
        System.out.println("dayOfMonth \t: " + dayOfMonth2);


        int fine = 0;
        if (c1.get(Calendar.YEAR) - c2.get(Calendar.YEAR) >= 0) {
            if (c1.get(Calendar.YEAR) - c2.get(Calendar.YEAR) == 0) {
                if (c1.get(Calendar.MONTH) - c2.get(Calendar.MONTH) >= 0) {
                    if (c1.get(Calendar.MONTH) - c2.get(Calendar.MONTH) == 0) {
                        if (c1.get(Calendar.DAY_OF_MONTH) - c2.get(Calendar.DAY_OF_MONTH) > 0) {
                            fine = (c1.get(Calendar.DAY_OF_MONTH) - c2.get(Calendar.DAY_OF_MONTH)) * 15;
                        }
                    } else
                        fine = (c1.get(Calendar.MONTH) - c2.get(Calendar.MONTH)) * 500;
                }


            } else {
                fine = 10000;
            }
        }
        System.out.println(fine);


        Calendar calendar1 = new GregorianCalendar(2013, 1, 28);//,13,24,56);

        int year = calendar1.get(Calendar.YEAR);
        int month = calendar1.get(Calendar.MONTH); // Jan = 0, dec = 11
        int dayOfMonth = calendar1.get(Calendar.DAY_OF_MONTH);
        int dayOfWeek = calendar1.get(Calendar.DAY_OF_WEEK);
        int weekOfYear = calendar1.get(Calendar.WEEK_OF_YEAR);
        int weekOfMonth = calendar1.get(Calendar.WEEK_OF_MONTH);

        int hour = calendar1.get(Calendar.HOUR);        // 12 hour clock
        int hourOfDay = calendar1.get(Calendar.HOUR_OF_DAY); // 24 hour clock
        int minute = calendar1.get(Calendar.MINUTE);
        int second = calendar1.get(Calendar.SECOND);
        int millisecond = calendar1.get(Calendar.MILLISECOND);


        System.out.println("year \t\t: " + year);
        System.out.println("month \t\t: " + month);
        System.out.println("dayOfMonth \t: " + dayOfMonth);
        System.out.println("dayOfWeek \t: " + dayOfWeek);
        System.out.println("weekOfYear \t: " + weekOfYear);
        System.out.println("weekOfMonth \t: " + weekOfMonth);

        System.out.println("hour \t\t: " + hour);
        System.out.println("hourOfDay \t: " + hourOfDay);
        System.out.println("minute \t\t: " + minute);
        System.out.println("second \t\t: " + second);
        System.out.println("millisecond \t: " + millisecond);
    }
}

class MySingletonDesignPattern {

}