package filesprocessing.Filters.FIlterExceptions;


import filesprocessing.Exceptions.TypeOneException;

public class BadFilterNameException extends TypeOneException
{
    //occurs when entering a bad filters name.
    private static final String ERROR_MSG = "Bad filter's command name";

    /**
     * Defualt Consructor with the informative message,
     */
    public BadFilterNameException()
    {
        super(ERROR_MSG);
    }

    public BadFilterNameException(String wrongName)
    {
        super(ERROR_MSG + wrongName);
    }
}
