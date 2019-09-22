package filesprocessing.Filters;



import filesprocessing.Exceptions.TypeOneException;
import filesprocessing.Filters.FIlterExceptions.BadParametersException;

import java.util.Arrays;


public class FilterFactory {

    //--------------------------------filters names-------------------------------------------------
    private final String GREATER_THEN = "greater_then";
    private final String BETWEEN = "between";
    private final String SMALLER_THEN = "smaller_then";
    private final String FILE_NAME = "file";
    private final String CONTAINS = "contains";
    private final String PREFIX = "prefix";
    private final String SUFFIX = "suffix";
    private final String IS_WRITABLE = "writable";
    private final String IS_EXECUTABLE = "executable";
    private final String IS_HIDDEN = "hidden";
    //--------------------------------filters names-------------------------------------------------

    private static final String SPLIT_CHAR = "#"; //char to split
    private static final String WARNING_MSG = "Warning in line "; //informative message
    private static boolean notSuffix = false; //not filter off
    private static final String NOT_FILTER = "NOT"; //Not parameter


    /**
     * Creates a filter object according to the given filter name
     * @param sectionArray - gets a string array which length is 0 if its only a name,
     * or greater then zero if it has parameters
     * @return Filter object
     * @throws TypeOneException
     */
    public static Filter createFilter(String[] sectionArray) throws TypeOneException
    {
        // if NOT is found when given a filter we turn notsuffix to true
        if(sectionArray.length >= 2 && (sectionArray[sectionArray.length-1].equals(NOT_FILTER)))
            //notSuffix = true;
                return new NegationFilter(FilterFactory.createFilter(Arrays.copyOfRange(sectionArray,0,sectionArray.length-1)));

        //handling all types of filters by the given name and creating the filter object
            switch (sectionArray[0])
            {
                case ("greater_than"):
                    double greaterThen = Double.parseDouble(sectionArray[1]);
                    if(greaterThen>=0)
                    {
                        if(notSuffix) //if Not was given
                            return new NegationFilter(new GreaterThenFilter(greaterThen));
                        return new GreaterThenFilter(greaterThen);}
                    else //if the parameters aren't good, throw
                        throw new BadParametersException(WARNING_MSG);

                case ("between"):
                    double value1 = Double.parseDouble(sectionArray[1]);
                    double value2 = Double.parseDouble(sectionArray[2]);

                    if(value1< value2 && value1>=0 && value2>0){ //param check
                        if(notSuffix)
                            return new NegationFilter(new BetweenFilter(value1,value2));
                        return new BetweenFilter(value1,value2);}
                    else
                        throw new BadParametersException(WARNING_MSG);

                case ("smaller_than"):
                    double smallerThen = Double.parseDouble(sectionArray[1]);
                    if(smallerThen>0){//param check
                        if(notSuffix)
                            return new NegationFilter(new SmallerThenFilter(smallerThen));
                        return new SmallerThenFilter(smallerThen);}
                    else//if the parameters aren't good, throw
                        throw new BadParametersException(WARNING_MSG);

                case ("file"):
                    String fileName = sectionArray[1];
                    if(notSuffix)
                        return new NegationFilter(new FileNameFilter(fileName));
                    return new FileNameFilter(fileName);

                case ("contains"):
                    String contains = sectionArray[1];
                    if(notSuffix)
                        return new NegationFilter(new ContainsFilter(contains));
                    return new ContainsFilter(contains);

                case ("prefix"):
                    String prefix = sectionArray[1];
                    if(notSuffix)
                        return new NegationFilter(new PrefixFilter(prefix));
                    return new PrefixFilter(prefix);

                case ("suffix"):
                    String suffix = sectionArray[1];
                    if(notSuffix)
                        return new NegationFilter(new SuffixFilter(suffix));
                    return new SuffixFilter(suffix);

                case ("writable"):
                    String writable = sectionArray[1];
                    if(writable.equals("YES")||writable.equals("NO")){//param check
                        if(notSuffix)
                            return new NegationFilter(new WritableFilter(writable));
                        return new WritableFilter(writable);}
                    else//if the parameters aren't good, throw
                        throw new BadParametersException(WARNING_MSG);

                case ("executable"):
                    String executable = sectionArray[1];
                    if((executable.equals("YES"))||(executable.equals("NO"))){//param check
                        if(notSuffix)
                            return new NegationFilter(new ExecutableFilter(executable));
                        return new ExecutableFilter(executable);}
                    else//if the parameters aren't good, throw
                        throw new BadParametersException(WARNING_MSG);

                case ("hidden"):
                    String hidden = sectionArray[1];
                    if((hidden.equals("YES"))||(hidden.equals("NO"))){//param check
                        if(notSuffix)
                            return new NegationFilter(new HiddenFilter(hidden));
                        return new HiddenFilter(hidden);}
                    else//if the parameters aren't good, throw
                        throw new BadParametersException(WARNING_MSG);

                case("all"):
                    if(notSuffix)
                        return new NegationFilter(new DefaultFilter());
                    return new DefaultFilter();

                default://default throw exception if you didn't find the filter name
                    // , we will handle it later and we'll give the Defualt filter
                    throw new BadParametersException(WARNING_MSG);


            }

    }


}



