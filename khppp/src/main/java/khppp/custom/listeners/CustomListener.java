package khppp.custom.listeners;
/**
 * Created by Sergey on 02.11.2014.
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class CustomListener extends TestListenerAdapter {

    Logger log = LogManager.getLogger(getClass());

    @Override
    public void onStart(ITestContext arg0) {
        log.info("Start Of Execution -> " + arg0.getName());
    }

    @Override
    public void onTestStart(ITestResult arg0) {
        log.info("Test Started -> " + arg0.getName());
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        log.info(tr.getName() + " --- SUCCESS\n");
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        log.error(tr.getName() + " --- FAILED");
        Throwable ex = tr.getThrowable();
        if (ex != null) {
            String cause = ex.toString();
            log.error(cause + "\n");
        }
    }


    @Override
    public void onTestSkipped(ITestResult tr) {
        log.info(tr.getName() + " --- SKIPPED");
    }

}
