import java.util.*;

public class alphabetical {
    public static void main(String[] args) {
        Scanner kb = new Scanner (System.in);
        String line = kb.next();

        Method1 (line);
        Method2 (line);
        Method3 (line);
        Method4 (line);
        Method5 (line);

    }
    public static void Method1 (String line){
        char[] ch = line.toCharArray();
        for (int j=0; j<line.length(); j++){
            for (int i = 0; i < line.length() - 1; i++) {
                if ((int) ch[i] > (int) ch[i + 1]) {
                    char temp = ch[i];
                    ch[i] = ch[i + 1];
                    ch[i + 1] = temp;
                }
            }
        }
        String str = new String(ch);
        System.out.println(str);
    }
    public static void Method2 (String line){
        char[] ch = line.toCharArray();
        for (int j=0; j<line.length(); j++){
            for (int i = 0; i < line.length() - 1; i++) {
                int x = (int) ch[i];
                if ((int) ch[i] > 90){
                    x = (int) ch[i] - 32;
                }
                int xx = (int) ch[i+1];
                if ((int) ch[i+1] > 90){
                    xx = (int) ch[i+1] - 32;
                }
                if (x > xx) {
                    char temp = ch[i];
                    ch[i] = ch[i + 1];
                    ch[i + 1] = temp;
                }
            }
        }
        String str = new String(ch);
        System.out.println(str);
    }
    public static void Method3 (String line){
        char[] ch = line.toCharArray();
        for (int j=0; j<line.length(); j++){
            for (int i = 0; i < line.length() - 1; i++) {
                int x = (int) ch[i];
                if ((int) ch[i] > 90){
                    x = (int) ch[i] - 32;
                }
                int xx = (int) ch[i+1];
                if ((int) ch[i+1] > 90){
                    xx = (int) ch[i+1] - 32;
                }
                if (x > xx) {
                    char temp = ch[i];
                    ch[i] = ch[i + 1];
                    ch[i + 1] = temp;
                }
                else if ( x == xx && (int) ch[i] > ch[i+1]){
                    char temp = ch[i];
                    ch[i] = ch[i + 1];
                    ch[i + 1] = temp;
                }
            }
        }
        String str = new String(ch);
        System.out.println(str);
    }
    public static void Method4 (String line){
        char[] ch = line.toCharArray();
        for (int j=0; j<line.length(); j++){
            for (int i = 0; i < line.length() - 1; i++) {
                int x = (int) ch[i];
                if ((int) ch[i] > 90){
                    x = (int) ch[i] - 32;
                }
                int xx = (int) ch[i+1];
                if ((int) ch[i+1] > 90){
                    xx = (int) ch[i+1] - 32;
                }
                if (x < xx) {
                    char temp = ch[i];
                    ch[i] = ch[i + 1];
                    ch[i + 1] = temp;
                }
                else if ( x == xx && (int) ch[i] < ch[i+1]){
                    char temp = ch[i];
                    ch[i] = ch[i + 1];
                    ch[i + 1] = temp;
                }
            }
        }
        String str = new String(ch);
        System.out.println(str);
    }
    public static void Method5 (String line){
        char[] ch = line.toCharArray();
        //System.out.println(ch);
        for (int j=0; j<line.length(); j++){
            for (int i = 0; i < line.length() - 1; i++) {
                int x = (int) ch[i];
                if ((int) ch[i] > 90){
                    x = (int) ch[i] - 32;
                }
                int xx = (int) ch[i+1];
                if ((int) ch[i+1] > 90){
                    xx = (int) ch[i+1] - 32;
                }
               // System.out.println("x: " + x  + " " + ch[i]);
               // System.out.println("xx: " + xx + " " + ch[i+1]);
                if (x > xx) {
                    char temp = ch[i];
                    ch[i] = ch[i + 1];
                    ch[i + 1] = temp;
                 //   System.out.println(ch);
                }
                else if ( x == xx && (int) ch[i] > ch[i+1]){
                    char temp = ch[i];
                    ch[i] = ch[i + 1];
                    ch[i + 1] = temp;
                //    System.out.println(ch);
                }
            }
        }
        String str = new String(ch);
        System.out.println(str);
    }
}
