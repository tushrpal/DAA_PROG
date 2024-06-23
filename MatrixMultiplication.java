import java.util.Scanner;

public class MatrixMultiplication {
    static int[][] c = new int[20][20];

    public int[][] matrixmul(int n, int l, int h, int[][] A, int[][] B) {
        if (n <= 2) {
            // Perform standard matrix multiplication for 2x2 matrices
            for (int i = l; i <= h; i++) {
                for (int j = l; j <= h; j++) {
                    for (int k = l; k <= h; k++) {
                        c[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
            return c;
        } else {
            int mid = ((l + h) / 2)-1;
            // Partition matrices and perform recursive calls
           c[0][0]=( matrixmul(n / 2, l, mid, A, B) )+ (matrixmul(n / 2, mid + 1, h, A, B));
            // matrixmul(n / 2, l, mid, A, B);
            // matrixmul(n / 2, mid + 1, h, A, B);
           
        }
    }

    public static void main(String[] args) {
        MatrixMultiplication mm = new MatrixMultiplication();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of matrix should be in 2's power (2,4,8,...)");
        int n = sc.nextInt();
        int[][] mat1 = new int[n][n];
        int[][] mat2 = new int[n][n];
        c = new int[n][n]; // Initialize the result matrix
        System.out.println("Enter the value of 1st matrix row wise");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat1[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter the value of 2nd matrix row wise");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat2[i][j] = sc.nextInt();
            }
        }
        int l = 0, h = n - 1;
        mm.matrixmul(n, l, h, mat1, mat2);

        System.out.println("Resultant Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
    }
}
