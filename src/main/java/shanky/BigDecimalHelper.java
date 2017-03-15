package shanky;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by sshek8 on 3/2/2017.
 */
public class BigDecimalHelper {

    public static void main(String[] args) {
        BigDecimal amount = round(BigDecimal.valueOf(5000).multiply(BigDecimal.valueOf(1053.781601)), 6).divide(BigDecimal.valueOf(1053.781601), 6, RoundingMode.HALF_UP);
        System.out.println(amount);
    }

    public static BigDecimal round(BigDecimal value, int decimals) {
        if (value == null) {
            return null;
        }
        return value.setScale(decimals, RoundingMode.HALF_UP);
    }
}
