import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class cheapestPath {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        int cheapest = 0;
        int ramd = num;
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> arr1 = new ArrayList<ArrayList<Integer>>();
        int[] st = new int[ramd * ramd];

        for (int i = 0; i < ramd; i++) {
            ArrayList<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j < ramd; j++) {
                row.add((int) (Math.random() * 201) - 100);
            }
            arr.add(row);
        }

        for (int i = 0; i < ramd; i++) {
            for (int j = 0; j < ramd; j++) {
                st[i * ramd + j] = arr.get(i).get(j);
            }
        }
        for (int i = 0; i < ramd; i++) {
            ArrayList<Integer> row1 = new ArrayList<Integer>();
            for (int j = 0; j < ramd; j++) {
                row1.add(st[i * ramd + j]);
            }
            arr1.add(row1);
        }
        for (int i = 0; i < ramd; i++) {
            for (int j = 0; j < ramd; j++) {
                System.out.print(" " + arr1.get(i).get(j) + "\t");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println();

        int i = 0, j = 0, com = arr1.get(0).get(0), n = ramd - 1, up = 0, down = 0, right = 0, left = 0, v = 0, o = 0;
        while (i < n || j < n) {
            System.out.print(arr1.get(i).get(j) + "     ");
            if (i > 0 && v != 1) {
                up = arr1.get(i - 1).get(j);
            } else {
                up = 200;
            }
            if (j > 0 && v != 2) {
                left = arr1.get(i).get(j - 1);
            } else {
                left = 200;
            }
            if (i < n && v != 3) {
                down = arr1.get(i + 1).get(j);
            } else {
                down = 200;
            }
            if (j < n && v != 4) {
                right = arr1.get(i).get(j + 1);
            } else {
                right = 200;
            }

            if (up < down && up < left && up < right) {
                com += up;
                i--;
                v = 3;
            }

            else if (left < down && left < right) {
                com += left;
                j--;
                v = 4;
            } else if (down < right) {
                com += down;
                i++;
                v = 1;
            } else {
                com += right;
                j++;
                v = 2;
            }

        }
        System.out.print(arr1.get(i).get(j) + "     ");

    }
}