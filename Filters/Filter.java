package filesprocessing.Filters;


import java.io.File;
import java.io.FileFilter;

//An abstract class represents a Filter object
public abstract class Filter implements FileFilter
{
    /**
     * Abstract method responsible for doing the filter.
     * @param myFile
     * @return
     */
    public abstract boolean accept(File myFile);

}
