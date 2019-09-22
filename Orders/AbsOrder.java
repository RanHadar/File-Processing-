package filesprocessing.Orders;


import java.io.File;
import java.util.Arrays;
import java.util.Collections;


public class AbsOrder extends Order

{
    @Override
    /**
     * Returns int represents a type of abs Order
     */
    public int compare(File FileOne, File FileTwo)
    {

        String AbsOne = FileOne.getAbsolutePath();
        String AbsTwo = FileTwo.getAbsolutePath();
        return AbsOne.compareTo(AbsTwo);

    }



}
