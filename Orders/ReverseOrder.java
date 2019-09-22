package filesprocessing.Orders;


import java.io.File;
import java.util.Comparator;

public class ReverseOrder extends Order
{
    private Comparator<File>comparator;

    /**
     * Default Constuctor - gets the type of order that needs to put it's revered order
     * @param comparator
     */
    public ReverseOrder(Comparator<File> comparator)
    {
        this.comparator = comparator;
    }

    @Override
    /**
     * Returns the revered order
     */
    public int compare(File FileOne, File FileTwo)
    {
        int outCome=comparator.compare(FileTwo,FileOne);
        if (outCome==0)
            return new AbsOrder().compare(FileTwo,FileOne);
        else return outCome;
    }
}
