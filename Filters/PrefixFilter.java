package filesprocessing.Filters;


import java.io.File;

public class PrefixFilter extends Filter {


    String preString;

    public PrefixFilter(String preString)
    {
        this.preString = preString;
    }

    @Override
    public boolean accept(File myFile) {
        return myFile.getName().startsWith(preString)&&!myFile.isDirectory();
    }
}
