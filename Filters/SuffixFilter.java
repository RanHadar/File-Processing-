package filesprocessing.Filters;


import java.io.File;

public class SuffixFilter extends Filter {


    String endsWith;

    /**
     * Default Constructor
     * @param endsWith
     */
    public SuffixFilter(String endsWith)
    {
        this.endsWith = endsWith;
    }


    @Override
    public boolean accept(File myFile) {
        return myFile.getName().endsWith(endsWith)&&!myFile.isDirectory();
    }
}
