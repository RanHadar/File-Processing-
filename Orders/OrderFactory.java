package filesprocessing.Orders;


import filesprocessing.Orders.OrderExceptions.BadOrderNameException;

import java.util.Collections;


public class OrderFactory
{
    //------------------------Orders names--------------------------------------------
    private static final String ABS_ORDER = "abs";
    private static final String TYPE_ORDER = "type";
    private static final String SIZE_ORDER = "size";
    //------------------------Orders names--------------------------------------------

    private static final String SPLIT_CHAR = "#"; //split char
    private static final String REVERSED = "REVERSE"; //reverse param

    private static final String WARNING_MSG = "Warning in line "; // informative message

    /**
     * Responsible for creating an Order object by a given name
     * @param orderToCreate - gets a string array which length is 0 if its only a name,
     * or greater then zero if it has parameters
     * @return
     * @throws BadOrderNameException
     */
    public static Order createOrder(String[] orderToCreate) throws BadOrderNameException
    {

        boolean reverse = false; // reverse set to be false at the first.

        if (orderToCreate.length == 2 && orderToCreate[1].equals(REVERSED))
            reverse = true; //change to true is Reveres is found


        //Responsible for creating an order by name
        switch (orderToCreate[0]) {
            case (ABS_ORDER):
                if (reverse) //reverse check
                    return new ReverseOrder(new AbsOrder());
                else
                    return new AbsOrder();

            case (TYPE_ORDER):
                if (reverse)//reverse check
                    return new ReverseOrder(new TypeOrder());
                else
                    return new TypeOrder();

            case (SIZE_ORDER):
                if (reverse)//reverse check
                    return new ReverseOrder(new SizeOrder());
                else
                    return new SizeOrder();

            default://default will throw an exception if the order didn't found and will
                // create after in another class the Abs order and will give warning
                throw new BadOrderNameException(WARNING_MSG);

        }

    }
}
