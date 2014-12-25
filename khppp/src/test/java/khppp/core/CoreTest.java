package khppp.core;

import khppp.excel.utils.ExcelReader;
import khppp.factory.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by Serhii_Pirohov on 10.11.2014.
 */
public final class CoreTest {
    public static final int COL_NUM = 0;
    public static final int DEFAULT_TIMEOUT = 30;
    protected WebDriver driver;
    private static Properties config;
    private static final String CONFIG_FILE = "src/main/resources/config.properties";


    public void setUpDriver(String browser) throws IOException {
        // Read config file
        loadProperties();
        // Prepare capabilities
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setBrowserName(browser);
        // Init driver
        driver = prepareDriver(cap);
        driver.manage().window().maximize();
        driver.manage().timeouts()
                .pageLoadTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
    }

    private void loadProperties() throws IOException {
        config = new Properties();
        config.load(new FileReader(CONFIG_FILE));
    }

    public void shutDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

	public Object[][] testData(Method method, String sheet) throws Exception {
		ExcelReader excelReader = new ExcelReader();
		excelReader.setExcelFile(config.getProperty("excel.workbook.path"), sheet);
		List<Integer> rowsNo = excelReader.getRowContains(method.getName(), COL_NUM);
		return excelReader.getTableArray(rowsNo);
	}



    public void open() {
        driver.get(config.getProperty("application.url"));
    }

    private WebDriver prepareDriver(DesiredCapabilities cap)
            throws MalformedURLException {
        String hubHost = config.getProperty("selenium.server.host");
        WebDriver driver = null;
        if (isUrl(hubHost)) {
            driver = new RemoteWebDriver(new URL(hubHost), cap);
        }
        return driver;
    }

    private static boolean isUrl(String urlString) {
        try {
            new URL(urlString);
            return true;
        } catch (MalformedURLException mue) {
            return false;
        }
    }

    public PageFactory getFactory() {
        return new PageFactory(driver);
    }
}
