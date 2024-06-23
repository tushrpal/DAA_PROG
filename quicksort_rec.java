
public class quicksort_rec {
    
    void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    int Partition(int a[], int l, int h) {
        int down = l;
        int up = h;
        int x = a[down];
    
        while (down < up) {
            while (a[down] <= x && down < h) {
                down++;
            }
            while (a[up] > x && up > l) {
                up--;
            }
            if (down < up) {
                swap(a, down, up);
            }
        }
        swap(a, up, l);
    
        return up;
    }

    void quicksort(int a[], int p, int q) {
        if (p < q) {
            int j = Partition(a, p, q);
            quicksort(a, p, j - 1);
            quicksort(a, j + 1, q);
        }
    }

    public static void main(String[] args) {
        quicksort_rec qs = new quicksort_rec();
        
        int a[] = {20, 10, 3, 2, 1, 25, 35, 21, 23, 12, 11};
        int h = a.length;
        int l = 0;
        qs.quicksort(a, l, h - 1);

        for (int i = 0; i < h; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
