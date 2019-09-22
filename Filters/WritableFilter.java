package filesprocessing.Filters;


import filesprocessing.Filters.FIlterExceptions.BadParametersException;

import java.io.File;


public class WritableFilter extends Filter
{
    private String yesOrNo;

    /**
     * Default Constructor
     * @param yesOrNo
     */
    public WritableFilter(String yesOrNo)
    {
        this.yesOrNo = yesOrNo;
    }

    @Override
    public boolean accept(File myFile)
    {
        if(yesOrNo.equals("YES"))
            return myFile.canWrite() == true&&!myFile.isDirectory();

        else
            return myFile.canWrite() == false&&!myFile.isDirectory();


    }
}
