import java.util.Scanner;
public class qudraticModel {
    public static void main(String[]args){
        Scanner kb=new Scanner(System.in);
double x1=kb.nextDouble();
double y1=kb.nextDouble();
double x2=kb.nextDouble();
double y2=kb.nextDouble();
double x3=kb.nextDouble();
double y3=kb.nextDouble();

double denominator=x1*x1*x2+x2*x2*x3+x3*x3*x1-x3*x3*x2-x2*x2*x1-x1*x1*x3;
double numeratora=y1*x2+y2*x3+y3*x1-y3*x2-y2*x1-y1*x3;
double numeratorb=y2*x1*x1+y3*x2*x2+y1*x3*x3-y2*x3*x3-y1*x2*x2-y3*x1*x1;
double numeratorc=x1*x1*x2*y3+x2*x2*x3*y1+x3*x3*x1*y2-x3*x3*x2*y1-x2*x2*x1*y3-x1*x1*x3*y2;
double a=numeratora/denominator;
double b=numeratorb/denominator;
double c=numeratorc/denominator;
System.out.println(String.format("Y=%fx^2+%fx+%f", a,b,c));
double h=-b/(2*a);
double k=c-a*h*h;
System.out.println(String.format("y=%f(x-%f)^2+%f", a,h,k));
    }
}
