package filesprocessing.Filters;


import java.io.File;

public class HiddenFilter extends Filter {

    private String yesOrNo;

    /**
     * Default Constructor
     * @param yesOrNo
     */
    public HiddenFilter(String yesOrNo)
    {
        this.yesOrNo = yesOrNo;
    }

    @Override
    /**
     * Return Yes/No
     */
    public boolean accept(File myFile)
    {
        if(yesOrNo.equals("YES"))
            return myFile.isHidden() == true&&!myFile.isDirectory();

        else
            return myFile.isHidden() == false&&!myFile.isDirectory();

    }
}
