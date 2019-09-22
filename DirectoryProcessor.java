package filesprocessing;

//-----------------------------------------imports----------------------------------------
import filesprocessing.Exceptions.Type2Exception;
import filesprocessing.Parsing.CommandFIleExceptions.BadFormatException;
import filesprocessing.Parsing.Parser;
import filesprocessing.Parsing.Section;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
//---------------------------------------------------------------------------------------

//Our Main class, responsible for running all the program, creates the relevant objects.
public class DirectoryProcessor {
    //informative message
    private static final String ARGS_ERR = "No more then two args are allowed";

    /**
     * Main method, runs all the program. the steps are as describe:
     * 1.reads the given args and checks them
     * 2.Creates a File object from the source dir in order to handle it
     * 3.Creates a Parser object in order to parse the command file given
     * 4.Creates all the sections in the command file
     * 5.Runs all over the Sections in the command file, for each section prints
     * error filters+orders the files in the dir and prints filtered,
     *
     * @param args
     * @throws IOException
     * @throws Type2Exception
     */
    public static void main(String args[]) throws IOException, Type2Exception {

        if (args.length > 2) //if received more then 2 args allowed throw type2.
            throw new InvalidUsageException(ARGS_ERR);

        String sourceDir = args[0]; //reads the given args.
        String commandFileDir = args[1];

        File folder = new File(sourceDir);// 2.turns into file object
        Parser parserFile = new Parser(); // 3.creates a Parse Object


        try //4. creates all the sections in the command file and catch relevant exceptions
        {
            ArrayList<String> commandFile = parserFile.commandFileReader(commandFileDir);
            ArrayList<Section> sectionsList = parserFile.createAllSections(commandFile);
            ArrayList<File> filteredFiles = new ArrayList<File>();

            for (Section curSection : sectionsList) {//5.runs all over the section and prints the output
                //filters
                File[] tempfilteredFiles = folder.listFiles(curSection.getFilerInSec());
                filteredFiles.addAll(Arrays.asList(tempfilteredFiles));
                Collections.sort(filteredFiles, curSection.getOrderInSec()); // sorts

                for (String warning : curSection.getWarnings())
                    System.err.println(warning);

                for (File file : filteredFiles) //prints the filtered ordered files
                    System.out.println(file.getName());

                filteredFiles = new ArrayList<File>();

            }


        } catch (BadFormatException e) { //catch type Two exception.
            System.err.println(e.getMessage());//prints warnings
        }

    }


    }

