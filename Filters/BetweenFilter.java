package filesprocessing.Filters;


import java.io.File;

public class BetweenFilter extends Filter {

    double greaterThen;
    double lowerThen;
    private final int Kbyte= 1024; //changing to k-bytes,

    /**
     * Default Constructor
     * @param greaterThen
     * @param lowerThen
     */
    public BetweenFilter(double greaterThen,double lowerThen)
    {
        this.greaterThen = greaterThen * Kbyte;
        this.lowerThen = lowerThen * Kbyte;
    }

    /**
     * OverRide
     * @param myFile
     * @return true if the file size is between.
     */
    public boolean accept(File myFile)
    {
        return (myFile.length() <= lowerThen && myFile.length() >= greaterThen&&!myFile.isDirectory());
    }
}
