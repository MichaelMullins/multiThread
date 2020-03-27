public class singleThread {
    public static int singleSum(int[] arr)
    {
        return singleSum(arr, 0, arr.length);
    }

    public static int singleSum(int[] arr, int low, int high)
    {
        int total = 0;

        for (int i = low; i < high; i++) {
            total += arr[i];
        }

        return total;
    }





}