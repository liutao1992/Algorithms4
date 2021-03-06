package 第二章_初级排序算法;

import static 第二章_初级排序算法.Text_Array.*;
import edu.princeton.cs.algs4.*;

public class Practise_2_1_25 {
    public static double insertion_A(int[] a) {
        Stopwatch timer = new Stopwatch();
        int N = a.length;
        for (int i = 1; i < N; i++) {
            int  t = a[i], j;
            for (j = i - 1; j >= 0 && t < a[j]; j--)
                a[j + 1] = a[j];
            a[j + 1] = t;
        }
        return timer.elapsedTime();
    }
    public static double insertion_B(int[] a) {
        Stopwatch timer = new Stopwatch();
        int N = a.length;
        for (int i = 1; i < N; i++) 
            for (int j = i; j > 0 && a[j - 1] > a[j]; j--) {
                int t = a[j];
                a[j] = a[j - 1];
                a[j - 1] = t;
            }
        return timer.elapsedTime();
    }
    public static void main(String[] args) {
        int[] arr = intRandom_bounds(1, 50000);
        int[] copy = intCopy_arr(arr);
        StdOut.printf("不交换 : %f\n", insertion_A(arr));
        StdOut.printf("交换 : %f\n", insertion_B(copy));
    }
    // output
    /*
     *  不交换 : 0.823000
        交换 : 1.225000
     */
}
