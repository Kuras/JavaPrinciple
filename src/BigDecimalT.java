import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Created by pkura on 2016-03-10.
 */
public class BigDecimalT {
    public static void main(String[] args) {
        String value = "1000000000.999999999999999";
        BigDecimal n1 = new BigDecimal("999999");
        BigDecimal n2 = new BigDecimal(9999999);

        System.out.println(n1.equals(n2));
        System.out.println(n1.compareTo(n2));
    }
}
