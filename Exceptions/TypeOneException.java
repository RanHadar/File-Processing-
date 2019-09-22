package filesprocessing.Exceptions;

//This is the Type One Exception which all the relevant other type1 exceptions exstands it,
public class TypeOneException extends Exception
{

    public TypeOneException()
    {
        super();
    }
    /**
     * Default Constructor
     * @param message
     */
    public TypeOneException(String message){
        super(message);
    }


}
