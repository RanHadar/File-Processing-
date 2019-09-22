package filesprocessing.Filters;


import java.io.File;

public class SmallerThenFilter extends Filter {

    double smallerThen;
    private final int Kbyte= 1024;


    /**
     * Default Constructor
     * @param smallerThen
     */
    public SmallerThenFilter(double smallerThen)
    {
        this.smallerThen = smallerThen * Kbyte;
    }

    @Override
    public boolean accept(File myFile) {
        return (myFile.length() < smallerThen&&!myFile.isDirectory());
    }
}
