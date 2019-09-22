package filesprocessing.Exceptions;


public class Type2Exception extends Exception
{
    //This is the Type Two Exception which all the relevant other type2 exceptions exstands it,

    private static String ERROR ="ERROR :"; //Informative message

    /**
     * Default Constructor
     * @param msg
     */
    public Type2Exception(String msg)
    {
        super(msg);
    }



}
