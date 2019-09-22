package filesprocessing.Filters;


import java.io.File;

//Wrapper class responsible for returning all the file's that didn't pass
// the relevant filter
public class NegationFilter extends Filter
{
    Filter filter;

    /**
     * Default Constructor
     * @param filter
     */
    public NegationFilter(Filter filter)
    {
        this.filter = filter;
    }

    @Override
    /**
     * Returns all the file's that didn't pass the relevant filter
     */
    public boolean accept(File myFile)
    {
        return !filter.accept(myFile)&&myFile.isFile();
    }
}
