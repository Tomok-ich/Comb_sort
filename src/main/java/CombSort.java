import java.util.ArrayList;

public class CombSort {

    public static class Result {
        public double time;
        public long iterations;

        public Result(double time, long iterations) {
            this.time = time;
            this.iterations = iterations;
        }
    }

    public static Result combSortArray(int[] arr) {
        int gap = arr.length;
        boolean swapped = true;
        double shrink = 1.3;

        long iterations = 0;

        long startTime = System.nanoTime();

        while (gap > 1 || swapped) {
            gap = (int) (gap / shrink);
            if (gap < 1) {
                gap = 1;
            }

            swapped = false;

            for (int i = 0; i + gap < arr.length; i++) {
                iterations++;

                if (arr[i] > arr[i + gap]) {
                    int temp = arr[i];
                    arr[i] = arr[i + gap];
                    arr[i + gap] = temp;
                    swapped = true;
                }
            }
        }

        long endTime = System.nanoTime();
        double timeMs = (endTime - startTime) / 1_000_000.0;

        return new Result(timeMs, iterations);
    }

    public static Result combSortList(ArrayList<Integer> arr) {
        int gap = arr.size();
        boolean swapped = true;
        double shrink = 1.3;

        long iterations = 0;

        long startTime = System.nanoTime();

        while (gap > 1 || swapped) {
            gap = (int) (gap / shrink);
            if (gap < 1) {
                gap = 1;
            }

            swapped = false;

            for (int i = 0; i + gap < arr.size(); i++) {
                iterations++;

                if (arr.get(i) > arr.get(i + gap)) {
                    int temp = arr.get(i);
                    arr.set(i, arr.get(i + gap));
                    arr.set(i + gap, temp);
                    swapped = true;
                }
            }
        }

        long endTime = System.nanoTime();
        double timeMs = (endTime - startTime) / 1_000_000.0;

        return new Result(timeMs, iterations);
    }
}
