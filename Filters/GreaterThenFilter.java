package filesprocessing.Filters;


import java.io.File;

public class GreaterThenFilter extends Filter
{
    private double gratherThen;
    private final int Kbyte= 1024; // turns to K-byte

    /**
     * Default Constructor
     * @param greatherThen
     */
    public GreaterThenFilter(double greatherThen)
    {
        this.gratherThen = greatherThen * Kbyte;
    }

    @Override
    /**
     * Returns true is the file's length is greater then the given param
     */
    public boolean accept(File myFile)
    {
        return (myFile.length() > gratherThen&&!myFile.isDirectory());
    }
}
