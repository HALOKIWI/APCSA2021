package TriangleCalculator;

public class triangle {
    private double side1 = 1;
    private double side2 = 1;
    private double side3 = 1;

    public boolean setSize(double sideOne, double sideTwo, double sideThree) {
        if (sideOne < 0 || sideTwo < 0 || sideThree < 0) {
            return false;
        } else if (sideOne + sideTwo < sideThree || sideOne + sideThree < sideTwo || sideTwo + sideThree < sideOne) {
            return false;
        }
        side1 = sideOne;
        side2 = sideTwo;
        side3 = sideThree;
        return true;
    }
    public double getPerimiter(){
        return side1+side2+side3;
    }
    public double getArea(){
        double s=getPerimiter()/2;
        double area=Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
        return area;
    }

}
