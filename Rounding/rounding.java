
//Create a program that takes TWO inputs, one is the number to round, second is how many places to KEEP.
// 1.2 1 > 1
// 1.8 1 > 2
// -1.2 1 > -1
// -1.8 1 > -2
// -1.293 2 > -1.3
// 1691 2 > 1700
// 16.21 1 > 20
// 0.888 1 > 0.9
// 0.9999 1 > 1.0
import java.util.Scanner;

public class rounding {
    public static void main(String[] args) {
        double one;
        int two;
        Scanner kb = new Scanner(System.in);
        System.out.println("Input Number one:");
        one = kb.nextDouble();
        System.out.println("Input Number two:");
        two = kb.nextInt();

        double result = round(one, two);
        System.out.println(result);

    }

    public static int coreRounding(double number) {
        if (number >= 0) {
            return (int) (number + 0.5);

        } else {
            return (int) (number - 0.5);

        }

    }

    public static double round(double one, int two) {
        if (one == 0) {
            return 0;
        }

        int digit = getDigitsNumber(one);
        if (one < 1 && one > -1) {
            digit = 0;
            int pow = 10;
            while (true) {
                if (Math.abs(one * pow) > 1) {
                    break;
                }
                pow *= 10;
                digit--;
            }
        }
        System.out.println(digit);
        one /= Math.pow(10, digit - two);
        one = coreRounding(one);
        one *= Math.pow(10, digit - two);

        return one;
    }

    public static int getDigitsNumber(final double d) {

        return (int) Math.log10(d) + 1;
    }
}