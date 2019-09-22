package filesprocessing.Filters.FIlterExceptions;


import filesprocessing.Exceptions.TypeOneException;

//occurs when entering a bad parameters to the filter.
public class BadParametersException extends TypeOneException
{

    /**
     * Defualt Consructor with the informative message,
     */
    public BadParametersException(String wrongParameter)
    {
        super(wrongParameter);
    }
}
