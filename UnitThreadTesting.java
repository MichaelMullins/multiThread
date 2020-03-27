import org.junit.Test;

import static org.junit.Assert.*;

public class UnitThreadTesting {


    @Test
    public void singleSum(){
        int[] testArr = new int[3];
        for (int x = 0; x < testArr.length; x++)
        {
            testArr[x] = x;
        }
        assertEquals(3,singleThread.singleSum(testArr));
    }

    @Test
    public void getPartialSum() {
        int[] testArr = new int[11];
        for (int x = 0; x < testArr.length; x++)
        {
            testArr[x] = x;
        }
        multiThread test = new multiThread(testArr, 1,11);
        test.run();


        assertEquals(55,test.getPartialSum());

    }

    @Test
    public void multiSummation() {

        int[] testArr = new int[10];
        for (int x = 0; x < testArr.length; x++)
        {
            testArr[x] = x;
        }
        int tot = multiThread.multiSummation(testArr);
        assertEquals(45,tot);
    }

    @Test
    public void sum() {
        int[] testArr = new int[6];
        for (int x = 0; x < testArr.length; x++)
        {
            testArr[x] = x;
        }
       int testNum=multiThread.sum(testArr, 1, 6);
        assertEquals(15,testNum);
    }


}