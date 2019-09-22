package filesprocessing.Orders;


import java.io.File;
import java.util.Comparator;

// an Abstract class represents an Order object
public abstract class Order implements Comparator<File>
{
    //One abstract method for comparing
    public abstract int compare(File FileOne, File FileTwo);
}
