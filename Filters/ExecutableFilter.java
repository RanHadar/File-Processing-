package filesprocessing.Filters;


import java.io.File;

public class ExecutableFilter extends Filter
{

    private String yesOrNo;

    /**
     * Default Constructor
     * @param yesOrNo
     */
    public ExecutableFilter(String yesOrNo)
    {
        this.yesOrNo = yesOrNo;
    }
    @Override
/**
 * Returns True/False according to given parameter
 */
    public boolean accept(File myFile)
    {
        if(yesOrNo.equals("YES"))
            return myFile.canExecute() == true&&!myFile.isDirectory();

        else
            return myFile.canExecute() == false&&!myFile.isDirectory();

    }
}
