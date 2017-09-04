
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dominic
 */
public class ParallelFilter extends RecursiveAction {

    int lo; // arguments
    int hi;
    int border;
    static Double[] arr, result;
    static int sequential_cutoff; //= 500;

    ParallelFilter(Double[] a, int l, int h, int border) {
        lo = l;
        hi = h;
        arr = a;
        this.border = border;
    }

    public Double medianFilter(Double[] array) {
        Arrays.sort(array);
        return array[border];
    }

    protected void compute() {
        if ((hi - lo) < sequential_cutoff) {
            for (int i = lo; i < hi; i++) {
                if ((i < border) || ( i >= (arr.length-border) )) {
                    result[i] = arr[i];
                    //System.out.printf("test result[%d]: %f\n", i, result[i] );
                } else {
                    //System.out.println("test");
                    result[i] = medianFilter(Arrays.copyOfRange(arr, i - border, i + border + 1));
                }
            }
        } else {
            int m = (int) Math.ceil((hi + lo) / 2);
            ParallelFilter left = new ParallelFilter(arr, lo, m, border);
            ParallelFilter right = new ParallelFilter(arr, m, hi, border);
            left.fork();
            right.compute();
            left.join();
        }
    }

}
