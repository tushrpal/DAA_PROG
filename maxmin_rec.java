import java.util.*;

public class maxmin_rec {
    static int max, min;

    public void minmax(int[] a, int l, int h) {
        if (l == h) {
            max = min = a[l];
        } else {
            if (l == h - 1) {
                if (a[l] < a[h]) {
                    max = a[h];
                    min = a[l];
                } else {
                    max = a[l];
                    min = a[h];
                }
            } else {
                int mid = l + (h - l) / 2;
                minmax(a, l, mid);
                int max1 = max;
                int min1 = min;
                minmax(a, mid + 1, h);
                if (max < max1) {
                    max = max1;
                }
                if (min > min1) {
                    min = min1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        maxmin_rec mn = new maxmin_rec();
        System.out.println("Enter the number of elements");
        int n = sc.nextInt();
        int a[] = new int[n];
        int l = 0, h = n - 1;
        for (int i = 0; i < n; i++) {
            System.out.println("enter the value");
            a[i] = sc.nextInt();
        }

        mn.minmax(a, l, h);
        System.out.println("max:- " + max + " min:- " + min);
    }
}
