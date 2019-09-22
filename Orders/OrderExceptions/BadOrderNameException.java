package filesprocessing.Orders.OrderExceptions;


import filesprocessing.Exceptions.TypeOneException;

public class BadOrderNameException extends TypeOneException
{

    /**
     * Default Constructor
     * @param wrongName
     */
    public BadOrderNameException(String wrongName)
    {
        super(wrongName);
    }

}
