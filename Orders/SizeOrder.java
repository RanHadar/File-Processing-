package filesprocessing.Orders;


import java.io.File;
import java.util.Arrays;
import java.util.Comparator;


public class SizeOrder extends Order
{

    @Override
    /**
     * Returns int represents a type of Size Order
     */
    public int compare(File FileOne, File FileTwo)
    {
        long SizeOne = FileOne.length();
        long SizeTwo = FileTwo.length();

        if(SizeOne > SizeTwo)
            return 1;
        else if(SizeOne < SizeTwo)
            return -1;
        else return new AbsOrder().compare(FileOne,FileTwo);

    }


}
