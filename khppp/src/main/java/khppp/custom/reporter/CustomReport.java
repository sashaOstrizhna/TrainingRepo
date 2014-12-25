package khppp.custom.reporter;

import org.testng.*;
import org.testng.xml.XmlSuite;

import java.util.*;

/**
 * Created by Sergey on 02.11.2014.
 */
public class CustomReport implements IReporter {

    @Override
    public void generateReport(List<XmlSuite> arg0, List<ISuite> arg1,
                               String outputDirectory) {

        // Second parameter of this method ISuite will contain all the suite executed.

        for (ISuite iSuite : arg1) {

            //Get a map of result of a single suite at a time

            Map<String, ISuiteResult> results = iSuite.getResults();

            //Get the key of the result map

            Set<String> keys = results.keySet();

            //Go to each map value one by one

            for (String key : keys) {

                //The Context object of current result

                ITestContext context = results.get(key).getTestContext();

                //Print Suite detail in Console

                System.out.println("Suite Name -> " + context.getName()

                        + "\n::Report output Ditectory -> " + context.getOutputDirectory()

                        + "\n::Suite Name->" + context.getSuite().getName()

                        + "\n::Start Date Time for execution -> " + context.getStartDate()

                        + "\n::End Date Time for execution -> " + context.getEndDate());


                //Get Map for only failed test cases

                IResultMap resultMap = context.getFailedTests();
                //Get method detail of failed test cases

                Collection<ITestNGMethod> failedMethods = resultMap.getAllMethods();

                //Loop one by one in all failed methods

                for (ITestNGMethod iTestNGMethod : failedMethods) {

                    System.out.println("\n--------FAILED TEST CASE---------");
                    //Print failed test cases detail

                    System.out.println("\nTESTCASE NAME -> " + iTestNGMethod.getMethodName()

                            + "\nDescription -> " + iTestNGMethod.getDescription()

                            + "\nPriority -> " + iTestNGMethod.getPriority()

                            + "\n:Date -> " + new Date(iTestNGMethod.getDate()));
                }
            }
        }
    }
}


