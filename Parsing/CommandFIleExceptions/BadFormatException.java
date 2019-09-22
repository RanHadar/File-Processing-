package filesprocessing.Parsing.CommandFIleExceptions;


public class BadFormatException extends Exception
{

    //informative message
    public static final String BAD_FORMAT ="ERROR : Bad subsection name";


    /**
     * Default Constructor
     */
    public BadFormatException()
    {
        super(BAD_FORMAT);
    }

}
