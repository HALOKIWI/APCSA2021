import java.util.*;

public class sortingPart2 {

    public static void main(String[] args) {
        //initialize arraylist
        Scanner kb = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        System.out.print("list is shown:  ");
        int n = (int)(Math.random()*2+5);
        for (int i=0; i<n; i++){
            int a = (int)(Math.random()*20)-10;
            list.add(a);
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        System.out.println("What number do you want to search for?");
        int s = kb.nextInt();
        linearSearch(s, list);
        binarySearch(s, list);

        linearSearchSelectionSort(s, list);
        binarySearchSelectionSort(s, list);

        linearSearchInsertionSort(s, list);
        binarySearchInsertionSort(s, list);

        linearSearchMergeSort(s, list);
        binarySearchMergeSort(s, list);

        linearSearchRadixSort(s, list);
        binarySearchRadixSort(s, list);
    }
    public static void linearSearch(int n, ArrayList<Integer> list){
        int a = 0;
        int count = 0;
        for(int i=0; i<list.size(); i++){
            count ++;
            if (list.get(i) == n){
                System.out.println("Linear search: index found at " + i + "     Count: " + count);
                a=1;
            }
        }
        if (a==0){
            System.out.println("Linear search: index found at " + -1 + "     Count: " + count);
        }
    }
    public static void binarySearch(int n, ArrayList<Integer> l){
        ArrayList<Integer> list=new ArrayList<Integer>();
        for (int i=0; i<sort(l).size(); i++){
            list.add(sort(l).get(i));
        }
        System.out.println("Find: " + n);
        System.out.print("These are your sorted numbers");
        for (int i=0; i<list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
        int mid = (int) (list.size())/2;
        bsearch(n, list);
    }
    public static void bsearch(int n, ArrayList<Integer> list){
        int count = 0;
        int index = 0;
        int min = 0;
        int max = list.size()-1;
        int mid = 0;
        while (min <= max)
        {
            mid = (min + max)/2;
            if (list.get(mid) == n)
            {
                index = mid;
                break;
            }
            else if (list.get(mid) < n)
            {
                min = mid + 1;
            }
            else
            {
                max = mid - 1;
            }
            index = -1;
            count++;
        }
        System.out.println();
        System.out.print("Binary search:   ");
        System.out.println("Index found at " + index);
        System.out.print("    Count: " + count);
    }
    public static ArrayList<Integer> sort(ArrayList<Integer> list){
        int num = 0;
        for (int j=0; j<list.size(); j++) {
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i) >  list.get(i+1)) {
                    int temp = list.get(i);
                    list.set(i, list.get(i+1));
                    list.set(i+1, temp);
                    num++;
                }
            }
        }
        return list;
    }

    public static ArrayList<Integer> selectionSort(ArrayList<Integer> list){
        int min = 999999;
        int index = 0;
        int num=0;

        for (int i=0; i<list.size(); i++){
            min = 9999;
            for (int j=i; j<list.size(); j++){
                if (list.get(j)<min){
                    min = list.get(j);
                    index = j;
                    num++;
                }
            }
            int temp = list.get(i);
            list.set(i, list.get(index));
            list.set(index, temp);
        }
        System.out.println("Selection sort Loops: "+num);
        return list;
    }
    public static void linearSearchSelectionSort(int n, ArrayList<Integer> l){
        ArrayList<Integer> list=new ArrayList<Integer>();
        for (int i=0; i<sort(l).size(); i++){
            list.add(selectionSort(l).get(i));
        }
        int a = 0;
        int count = 0;
        for(int i=0; i<list.size(); i++){
            count ++;
            if (list.get(i) == n){
                System.out.println("Linear search: found index at " + i + "Count: " + count);
                a=1;
            }
        }
        if (a==0){
            System.out.println("Linear search: found index at " + -1 + " Count: " + count);
        }
    }
    public static void binarySearchSelectionSort(int n, ArrayList<Integer> l){
        ArrayList<Integer> list=new ArrayList<Integer>();
        for (int i=0; i<sort(l).size(); i++){
            list.add(sort(l).get(i));
        }
        System.out.println("Find: " + n);
        System.out.print("Sorted list is shown:  ");
        for (int i=0; i<list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
        int mid = (int) (list.size())/2;
        bsearchSelectionSort(n, list);
    }
    public static void bsearchSelectionSort(int n, ArrayList<Integer> list){
        int count = 0;
        int index = 0;
        int min = 0;
        int max = list.size()-1;
        int mid = 0;
        while (min <= max)
        {
            mid = (min + max)/2;
            if (list.get(mid) == n)
            {
                index = mid;
                break;
            }
            else if (list.get(mid) < n)
            {
                min = mid + 1;
            }
            else
            {
                max = mid - 1;
            }
            index = -1;
            count++;
        }
        System.out.println();
        System.out.print("Binary search:");
        System.out.print("Index found at " + index);
        System.out.print("Count: " + count);
    }

    public static ArrayList<Integer> insertionSort(ArrayList<Integer> list){
        int num = 0;
        for (int i=0; i<list.size(); i++){
            for (int j=0; j<i; j++){
                for (int x=0; x<i; x++){
                    if (list.get(j) >  list.get(j+1)) {
                        int temp = list.get(j);
                        list.set(j, list.get(j+1));
                        list.set(j+1, temp);
                        num++;
                    }
                }
            }
        }
        System.out.println("Insertion sort Loops: "+num);
        return list;
    }
    public static void linearSearchInsertionSort(int n, ArrayList<Integer> l){
        ArrayList<Integer> list=new ArrayList<Integer>();
        for (int i=0; i<sort(l).size(); i++){
            list.add(insertionSort(l).get(i));
        }
        int a = 0;
        int count = 0;
        for(int i=0; i<list.size(); i++){
            count ++;
            if (list.get(i) == n){
                System.out.println("Linear search: found index at " + i + "     Count: " + count);
                a=1;
            }
        }
        if (a==0){
            System.out.println("Linear search: found index at " + -1 + "     Count: " + count);
        }
    }
    public static void binarySearchInsertionSort(int n, ArrayList<Integer> l){
        ArrayList<Integer> list=new ArrayList<Integer>();
        for (int i=0; i<sort(l).size(); i++){
            list.add(sort(l).get(i));
        }
        System.out.println("Find: " + n);
        System.out.print("Sorted list is shown:  ");
        for (int i=0; i<list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
        int mid = (int) (list.size())/2;
        bsearchInsertionSort(n, list);
    }
    public static void bsearchInsertionSort(int n, ArrayList<Integer> list){
        int count = 0;
        int index = 0;
        int min = 0;
        int max = list.size()-1;
        int mid = 0;
        while (min <= max)
        {
            mid = (min + max)/2;
            if (list.get(mid) == n)
            {
                index = mid;
                break;
            }
            else if (list.get(mid) < n)
            {
                min = mid + 1;
            }
            else
            {
                max = mid - 1;
            }
            index = -1;
            count++;
        }
        System.out.println();
        System.out.print("Binary search:   ");
        System.out.print("Index found at " + index);
        System.out.print("    Count: " + count);
    }

    public static ArrayList<Integer> mergeSort (ArrayList<Integer> list, int count) {
        if (list.size() > 1)
        {
            int mid = list.size()/2;
            ArrayList<Integer> left = new ArrayList<Integer>();
            ArrayList<Integer> right = new ArrayList<Integer>();

            for (int i = 0; i < mid; i++)
            {
                left.add(list.get(i));
            }

            for (int i = mid; i < list.size(); i++)
            {
                right.add(list.get(i));
            }

            left = mergeSort(left, count);
            right = mergeSort(right, count);

            int i = 0;
            int j = 0;
            int k = 0;

            while (i < left.size() && j < right.size())
            {
                if (left.get(i) < right.get(j))
                {
                    list.set(k, left.get(i));
                    i++;
                    count++;
                }
                else
                {
                    list.set(k, right.get(j));
                    j++;
                }
                k++;
            }

            while (i < left.size())
            {
                list.set(k, left.get(i));
                i++;
                k++;
            }

            while (j < right.size())
            {
                list.set(k, right.get(j));
                j++;
                k++;
            }
        }
        System.out.println("Merge sort Loops: "+count);
        return list;
    }
    public static void linearSearchMergeSort(int n, ArrayList<Integer> l){
        ArrayList<Integer> list=new ArrayList<Integer>();
        for (int i=0; i<l.size(); i++){
            list.add(mergeSort(l, 0).get(i));
        }
        int a = 0;
        int count = 0;
        for(int i=0; i<list.size(); i++){
            count ++;
            if (list.get(i) == n){
                System.out.println("Linear search: index found at " + i + "     Count: " + count);
                a=1;
            }
        }
        if (a==0){
            System.out.println("Linear search: index found at " + -1 + "     Count: " + count);
        }
    }
    public static void binarySearchMergeSort(int n, ArrayList<Integer> l){
        ArrayList<Integer> list=new ArrayList<Integer>();
        for (int i=0; i<l.size(); i++){
            list.add(mergeSort(l,0).get(i));
        }
        System.out.println("Find: " + n);
        System.out.print("Sorted list is shown:  ");
        for (int i=0; i<list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
        int mid = (int) (list.size())/2;
        bsearch(n, list);
    }

    public static ArrayList<Integer> radixSort (ArrayList<Integer> list){
        int num = 0;int temp = 0;
        for (int i = 0; i < list.size(); i++) {
            temp = list.get(i);
            num = i;
            while (num > 0 && list.get(num - 1) > temp) {
                list.set(num, list.get(num - 1));
                num--;
            }
            list.set(num, temp);
        }
        System.out.println("Radix sort Loops: "+num);
        return list;
    }
    public static void linearSearchRadixSort(int n, ArrayList<Integer> l){
        ArrayList<Integer> list=new ArrayList<Integer>();
        for (int i=0; i<l.size(); i++){
            list.add(radixSort(l).get(i));
        }
        int a = 0;
        int count = 0;
        for(int i=0; i<list.size(); i++){
            count ++;
            if (list.get(i) == n){
                System.out.println("Linear search: index found at " + i + "     Count: " + count);
                a=1;
            }
        }
        if (a==0){
            System.out.println("Linear search:index found at " + -1 + "     Count: " + count);
        }
    }
    public static void binarySearchRadixSort(int n, ArrayList<Integer> l){
        ArrayList<Integer> list=new ArrayList<Integer>();
        for (int i=0; i<l.size(); i++){
            list.add(radixSort(l).get(i));
        }
        System.out.println("Find: " + n);
        System.out.print("sorted list is shown: ");
        for (int i=0; i<list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
        int mid = (int) (list.size())/2;
        bsearch(n, list);
    }
}