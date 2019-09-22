package filesprocessing.Orders;

import java.io.File;

public class TypeOrder extends Order
{
    private String EMPTY_STRING = "";

    @Override
    /**
     * Returns int represents a type of a Type Order
     */
    public int compare(File FileOne, File FileTwo)
    {

        String[] s1 = FileOne.getName().split("[.]");
        String[] s2 = FileTwo.getName().split("[.]");
        String s1Name;
        String s2Name;
//checks if one of the files dosen't have an ending. so turn to an EmptyString
        if(s1.length == 1)
            s1Name = EMPTY_STRING;
        else
            s1Name =s1[s1.length-1];

        if(s2.length == 1)
            s2Name = EMPTY_STRING;
        else
            s2Name =s2[s2.length-1];

        int outCome = s1Name.compareTo(s2Name);
        if (outCome==0)
            return new AbsOrder().compare(FileOne,FileTwo);
        else
            return outCome;

    }

}
