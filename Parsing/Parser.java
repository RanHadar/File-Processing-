package filesprocessing.Parsing;


//-------------------------------------------imports----------------------------------------------
import filesprocessing.Exceptions.TypeOneException;
import filesprocessing.Filters.DefaultFilter;
import filesprocessing.Filters.Filter;
import filesprocessing.Filters.FilterFactory;
import filesprocessing.Orders.AbsOrder;
import filesprocessing.Orders.Order;
import filesprocessing.Orders.OrderFactory;
import filesprocessing.Parsing.CommandFIleExceptions.BadFormatException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;
//-------------------------------------------imports----------------------------------------------

public class Parser {

    private Scanner scannerFile;
    private final String SPLIT_CHAR = "#";
    private final String FILTER_HEADER = "FILTER";
    private final String ORDER_HEADER = "ORDER";
    private final String WARNING_MSG = "Warning in line "; //informative message


    private int sectionCounter;
    private ArrayList<Section> fileSections;


    /**
     * Default Constructor
     */
    public Parser()
    {

        sectionCounter = 0;
        fileSections = new ArrayList<Section>();

    }

    /**
     * Responsible for reading the command file and turns it to a array list of strings.
     * @param commandfile
     * @return Array List of strings
     * @throws IOException
     */
    public ArrayList<String> commandFileReader(String commandfile) throws IOException
    {

        ArrayList<String> commandFileLines = new ArrayList<String>();

        //turns the given command file into a File object in order
        // to handle it has a file.
        File commandReader = new File(commandfile);

        try { //tries to read the file if not throws an exception
            scannerFile = new Scanner(commandReader);
        }
        catch (java.io.FileNotFoundException e)
        {
            throw new FileNotFoundException();
        }

        String nextLine = scannerFile.nextLine();


        while(scannerFile.hasNextLine())
        {//reading all the file and adding to the array list.
            commandFileLines.add(nextLine);
            nextLine = scannerFile.nextLine();
        }
        commandFileLines.add(nextLine);
        scannerFile.close();
        return commandFileLines;
    }

    /**
     * Gets a command file represents as arraylist of strings and Reads it Line by line.
     * The main idea is that section as to be 4 lines from the array and if its not we add the
     * relevant parameters to the empty cells and continues.
     * Inside it calls to another method that creates a single section,
     * @param comFile - gets a command file represents as array list of strings.
     * @return - an arraylist of sections contains all the sections in the given file.
     * @throws BadFormatException
     */
    public ArrayList<Section> createAllSections(ArrayList<String> comFile) throws BadFormatException
    {
        int lineNumber = 0;

        ArrayList<String> sectionToCreate = new ArrayList<String>();
        for(int i=0; i<comFile.size();i++)
        {
            //switch which reponsible for moving all over the lines and
            // in each case checks his relevant options for options to be
            // shown and handles it.
            switch (lineNumber)
            {
                case (0):
                    if(!comFile.get(i).equals(FILTER_HEADER))
                        throw new BadFormatException();

                    sectionToCreate.add(comFile.get(i));
                    lineNumber++; //promotes the line number
                    break;

                case(1):

                    if(comFile.get(i).equals(ORDER_HEADER)) {
                        sectionToCreate.add("all");
                        sectionToCreate.add(comFile.get(i));
                    }
                    else if(comFile.get(i).equals(FILTER_HEADER)) {
                        sectionToCreate.add("wrong_input");
                    }
                    else
                        sectionToCreate.add(comFile.get(i));

                    lineNumber++;
                    break;

                case(2):
                    if(comFile.get(i).equals(FILTER_HEADER))
                    {
                        sectionToCreate.add("abs");
                        sectionToCreate.add(comFile.get(i));
                    }
                    else if(!comFile.get(i).equals(ORDER_HEADER))
                        throw new BadFormatException();
                    else
                        sectionToCreate.add(comFile.get(i));

                    lineNumber++;
                    break;

                case(3):
                    if(comFile.get(i).equals(FILTER_HEADER))
                    {
                        sectionToCreate.add("abs");
                        lineNumber++;
                        i--;
                        //take the i one back not to lose the given FILTER HEADER
                        // in order to enter it to the next section because we close
                        // a section in this situation
                    }
                    else {
                        sectionToCreate.add(comFile.get(i));
                        lineNumber++;
                    }

                    break;
            }
            //if we reach to four we close creates a single section and reboot the array list
            if(lineNumber == 4)
            {
                fileSections.add(createSection(sectionToCreate,comFile));
                sectionToCreate = new ArrayList<String>();
            }

            lineNumber = lineNumber%4;

        }
        return fileSections; //returns all the sections created

    }

    /**
     * Creates a single section by a given parameters using the Filter/Order Factories.
     * @param commands
     * @return a new section
     * @throws BadFormatException
     */
    public Section createSection(ArrayList<String> commands,ArrayList<String>comFile) throws BadFormatException
    {
        ArrayList<String> SectionWarning = new ArrayList<String>();
        if(commands.size() != 4) //section must be in length four
            throw new BadFormatException();

        String[] FilterToCreate =commands.get(1).split(SPLIT_CHAR);
        String[] OrderToCreate = commands.get(3).split(SPLIT_CHAR);

        Filter sectionFilter;
        Order sectionOrder;

        try { // tries to create a filter
            sectionFilter = FilterFactory.createFilter(FilterToCreate);

        }
        catch (TypeOneException e)
        {
            //if the filter hasn't found prints a warning and creates the default filter
            int lineNumber = comFile.indexOf(commands.get(1))+1;
            SectionWarning.add(WARNING_MSG+lineNumber);
            sectionFilter = new DefaultFilter();
        }

        try
        { //tries to create an order
            sectionOrder = OrderFactory.createOrder(OrderToCreate);
        }
        catch(TypeOneException e)
        {
            //if the order hasn't found prints a warning and creates the default order,
            int lineNumber = comFile.indexOf(commands.get(3))+1;
            SectionWarning.add(WARNING_MSG+lineNumber);
            sectionOrder = new AbsOrder();
        }


        return new Section(sectionFilter,sectionOrder,SectionWarning);


    }



}



