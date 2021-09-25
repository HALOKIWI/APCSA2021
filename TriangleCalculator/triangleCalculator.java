package TriangleCalculator;

import java.util.*;
public class triangleCalculator {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        triangle t = new triangle();

        while (true) {
            String selection;
            System.out.print("Do you want Area(A), Perimeter(P), Edit the Triangle (E), or Exit the Program (X)\n>");
            selection = kb.nextLine().toLowerCase();
            if (selection.equals("a")) {
                System.out.println("Area is " + t.getArea());
            } else if (selection.equals("p")) {
                System.out.println("Perimeter is " + t.getPerimiter());

            } else if (selection.equals("e")) {
                System.out.print("Input Triangle Dimensions:\n>");
                while (true) {
                    double side1, side2, side3;
                    side1 = kb.nextDouble();
                    side2 = kb.nextDouble();
                    side3 = kb.nextDouble();
                    if (t.setSize(side1, side2, side3)) {
                        break;
                    } else {
                        System.out.print("Invalid Triangle\n>");
                    }

                }
            }else if(selection.equals("x")){
                System.out.println("Thank you for your time!");
                break;
            }

        }

    }
}