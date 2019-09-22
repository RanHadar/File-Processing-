package filesprocessing;


import filesprocessing.Exceptions.Type2Exception;

public class InvalidUsageException extends Type2Exception
{
    /**
     * Default Constructor - gets the relevant error message to be thrown later.
     * @param msg
     */
    public InvalidUsageException(String msg) {
        super(msg);
    }
}
