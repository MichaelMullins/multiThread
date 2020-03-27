import java.util.Random;

public class main {

    public static void main(String[] args)
    {
        int[] randArr = new int[200000000];
        Random rand = new Random();
        for (int x = 0; x < randArr.length; x++) {
            randArr[x] = rand.nextInt(101) + 1;
        }
        long multiRuntime =0;
        long singleRuntime = 0;
        long start = System.currentTimeMillis();
        int check = multiThread.multiSummation(randArr);
        multiRuntime = System.currentTimeMillis() - start;

        System.out.println("Multi Threaded Runtime:   " + multiRuntime+" Ms"+check);

        start = System.currentTimeMillis();

        singleThread.singleSum(randArr); //ignoring return; just checking runtime.
        singleRuntime = System.currentTimeMillis() - start;

        System.out.println("Single Threaded Runtime:  " +singleRuntime + " Ms");

        System.out.println("MultiThreaded Runtime is  "+ (singleRuntime-multiRuntime)+" Ms faster");
    }
}
