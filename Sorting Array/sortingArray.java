import java.util.ArrayList;

public class sortingArray {

    public static void main(String[] args) {
         Arraygen(5);
        arrGen(5);
        Arr2Dgen(5,4);

        ArrList2Dgen(5, 4);

    }

    public static void Arraygen(int n) {
        int arr[] = new int[n];
        System.out.println("Start: ");
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * 200) - 100;
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        sort(arr);
        System.out.println("Processed: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int[] sort(int[] arr) {
        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i]; 
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static void arrGen(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        System.out.println("Start: ");
        for (int i = 0; i < n; i++) {
            list.add((int) (Math.random() * 200) - 100);
        }
        System.out.println(list);
        sort(list);
        System.out.println("Processed: ");
        System.out.println(list);
    }

    public static ArrayList<Integer> sort(ArrayList<Integer> list) {
        for (int j = 0; j < list.size(); j++) {
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i) > list.get(i + 1)) {
                    int temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                }
            }
        }
        return list;
    }

    public static void Arr2Dgen(int n, int m) {
        int arr[][] = new int[n][m];
        System.out.println("Start: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = (int) (Math.random() * 200) - 100;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        sort(arr);
        System.out.println("Processed: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] sort(int[][] arr) {
        int a = arr.length;
        int b = arr[0].length;
        int[] temporary = new int[a * b];
        int x = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                temporary[x] = arr[i][j];
                x++;
            }
        }
        for (int j = 0; j < temporary.length; j++) {
            for (int i = 0; i < temporary.length - 1; i++) {
                if (temporary[i] > temporary[i + 1]) {
                    int temp = temporary[i];
                    temporary[i] = temporary[i + 1];
                    temporary[i + 1] = temp;
                }
            }
        }
        int xx = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = temporary[xx];
                xx++;
            }
        }
        return arr;
    }

    public static void ArrList2Dgen(int n, int m) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        for (int j = 0; j < n; j++) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < m; i++) {
                list.add((int) (Math.random() * 200) - 100);
            }
            arr.add(list);
        }
        System.out.println("Start: ");
        System.out.println(arr);
        sort2D(arr);
        System.out.println("Processed: ");
        System.out.println(arr);
    }

    public static ArrayList<ArrayList<Integer>> sort2D(ArrayList<ArrayList<Integer>> arr) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.get(0).size(); j++) {
                list.add(arr.get(i).get(j));
            }
        }
        for (int j = 0; j < list.size(); j++) {
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i) > list.get(i + 1)) {
                    int temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                }
            }
        }
        int x = 0;
        for (int j = 0; j < arr.size(); j++) {
            ArrayList<Integer> li = new ArrayList<Integer>();
            for (int i = 0; i < arr.get(0).size(); i++) {
                li.add(list.get(x));
                x++;
            }
            arr.set(j, li);
        }

        return arr;
    }
}