package filesprocessing.Parsing;


import filesprocessing.Filters.Filter;
import filesprocessing.Orders.Order;

import java.io.File;
import java.util.ArrayList;

//Represents a Single Section in the program which contains a Filter and Order Objects.
public class Section extends ArrayList<File>
{
    private Filter filterInSec;
    private Order orderInSec;
    private ArrayList<String> SectionWarnings;

    /**
     * Default Constructor
     * @param filterInSec
     * @param orderInSec
     */
    public Section(Filter filterInSec,Order orderInSec,ArrayList<String> SectionWarnings)
    {
        this.filterInSec = filterInSec;
        this.orderInSec = orderInSec;
        this.SectionWarnings = SectionWarnings;
    }

    /**
     * Gets the section's filter
     * @return
     */
    public Filter getFilerInSec()
    {
        return filterInSec;
    }

    /**
     * Gets the section's order
     * @return
     */
    public Order getOrderInSec()
    {
        return orderInSec;
    }

    public ArrayList<String> getWarnings()
    {
        return this.SectionWarnings;
    }




}
