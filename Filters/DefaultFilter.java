package filesprocessing.Filters;

import java.io.File;


public class DefaultFilter extends Filter
{
    @Override
    /**
     * Defualt filter- returns all the files without filtering
     */
    public boolean accept(File myFile)
    {
        return !myFile.isDirectory();

    }
}
