package filesprocessing.Filters;


import java.io.File;

public class ContainsFilter extends Filter
{
    String contains;
    public ContainsFilter(String contains)
    {
        this.contains =contains;
    }

    @Override
    /**
     * Returns true if the file's name contains the string
     */
    public boolean accept(File myFile) {
        return myFile.getName().contains(contains)&&!myFile.isDirectory();
    }
}
