import java.text.NumberFormat;

import java.util.Scanner;

public class Teilor {
    int k=0;
    double x=0;
    double sum = 0;

    public void Read() {
        Scanner in = new Scanner(System.in);
        System.out.println("k: ");
        k = in.nextInt();
        System.out.println("x: ");
        x = in.nextDouble();
    }

    public void sum() {
        double slag = x;
        sum = slag;
        //int d=2;
        double eps = Math.pow(10, (-k));
        int i = 3;
        while (Math.abs(slag) > eps) {
            slag *= ((-1) * (x * x)) / (i * (i - 1));

            sum += slag;
            i+=2;
        }
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(k + 1);
        System.out.println("sum: " + formatter.format(sum));
        double temp = Math.sin(x);
        System.out.println("sin: " + formatter.format(temp));
    }
}
