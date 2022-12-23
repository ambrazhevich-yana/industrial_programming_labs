import java.text.NumberFormat;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Scanner;

public class Teilor {
    BigInteger k = BigInteger.valueOf(0);
    BigDecimal x = BigDecimal.valueOf(0);
    BigDecimal sum = BigDecimal.valueOf(0);

    public void Read() {
        Scanner in = new Scanner(System.in);
        System.out.println("k: ");
        k = BigInteger.valueOf(in.nextInt());
        System.out.format("K 16: %X %nK 8: %o %n", k, k);
        System.out.println("x: ");
        x = BigDecimal.valueOf(in.nextDouble());

    }

    public void sum() {
        BigDecimal slag = x;
        sum = slag;
        BigDecimal eps = BigDecimal.valueOf(Math.pow(10,-(k.doubleValue())));
        BigDecimal i = BigDecimal.valueOf(3);
        while ((Math.abs(slag.doubleValue()))>eps.doubleValue() ) {
            slag = slag.multiply(BigDecimal.valueOf(-1)) ;
            slag = slag.multiply(x);
            slag = slag.multiply(x);
            slag =slag.divide(i, RoundingMode.HALF_UP);
            slag = slag.divide((i.add(BigDecimal.valueOf(-1))),RoundingMode.HALF_UP);
            sum = sum.add(slag);
            i = i.add(BigDecimal.valueOf(2));
        }
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(k.intValue() + 1);
        System.out.println("sum: " + formatter.format(sum));
        BigDecimal temp = BigDecimal.valueOf(Math.sin(x.doubleValue()));
        System.out.println("sin: " + formatter.format(temp));

        System.out.format("Teilor   sin(x) = %+015f %n", sum);
        System.out.format("Standart sin(x) =  %#.5f %n", temp);
        System.out.format("%2$d %1$(d %3$,d" , -20, 20, 100000);
    }
}