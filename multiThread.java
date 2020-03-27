public class multiThread extends Thread {
    private int[] arr;
    private int low;
    private int partial;
    private int high;

    public multiThread(int[] arr, int low, int high)
    {
        this.arr = arr;
        this.low = low;
        this.high = Math.min(high, arr.length);
    }


    public void run()
    {
        partial = sum(arr, low, high);
    }

    public int getPartialSum()
    {
        return partial;
    }
    public static int multiSummation(int[] arr)
    {
        int numOfThreads =  Runtime.getRuntime().availableProcessors();
        int total = multiSummation(arr, numOfThreads); //available processors returns total available threads.
        return total;
    }
    public static int sum(int[] arr, int low, int high)
    {
        int total = 0;

        for (int i = low; i < high; i++) {
            total += arr[i];
        }

        return total;
    }



    public static int multiSummation(int[] arr, int threadCount)
    {
        multiThread[] sums = new multiThread[threadCount];
        int size = (int) Math.ceil(arr.length / threadCount);
        for (int i = 0; i < threadCount; i++) {
            int low = i*size;
            int high = (i + 1) * size;
            sums[i] = new multiThread(arr, low, high);
            sums[i].start();
        }

        try {
            for (multiThread sum : sums) {
                sum.join();
            }
        } catch (InterruptedException ignored) { }

        int total = 0;

        for (multiThread sum : sums) {
            total += sum.getPartialSum();
        }

        return total;
    }

}