package filesprocessing.Filters;

import java.io.File;


public class FileNameFilter extends Filter {

    String fileName;

    /**
     * Default Constructor
     * @param fileName
     */
    public FileNameFilter(String fileName)
    {
        this.fileName=fileName;
    }
    @Override
    /**
     * Returns True/False if file's name is the same
     */
    public boolean accept(File myFile) {
        return (myFile.getName().equals(fileName)&&!myFile.isDirectory());
    }
}
