import java.util.*;

public class forLoops {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = input.nextInt();

        if (num > 90 && num <= 100) {
            System.out.println("Yay!");
        } else if (num > 80) {
            System.out.println("Good Job!");
        } else if (num > 70) {
            System.out.println("Nice Effort!");
        } else if (num > 60) {
            System.out.println("Good Try!");
        } else {
            System.out.println("Try again!");
        }
    }

    public String Nested(int g) {
        if (g > 0) {
            if (g > 60) {
                if (g > 70) {
                    if (g > 80) {
                        if (g > 90) {
                            return "Yay!";
                        }
                        return "Good Job!";
                    }
                    return "Nice Effort!";
                }
                return "Good Try!";
            }
            return "Try again!";
        }
        return "";
    }

    public String chainedIf(int g) {
        if (g > 90)
            return "Yay!";
        if (g > 80 && g < 90)
            return "Good Job!";
        if (Math.abs(g - 75) < 5)
            return "Nice Effort!";
        if (g > 60 && g < 70)
            return "Good Try!";
        if (g < 60)
            return "Try again!";
        return "";
    }

    public String switchCase(int g) {
        int n = (int) g / 10;
        switch (n) {
            case 9:
                return "Yay!";
            case 8:
                return "Good Job!";
            case 7:
                return "Nice Effort!";
            case 6:
                return "Good Try!";
            default:
                return "Try again!";
        }
    }
}