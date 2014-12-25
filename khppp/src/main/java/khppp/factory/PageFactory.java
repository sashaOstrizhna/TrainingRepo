package khppp.factory;

import org.openqa.selenium.WebDriver;

/**
 * Created by Serhii_Pirohov on 06.11.2014.
 */
public class PageFactory {

    private WebDriver driver;

    public PageFactory(WebDriver driver) {
        this.driver = driver;
    }

    /*
     * Method instantiate page
     */
    public <T> T createPage(Class<T> pageClassToProxy) {
        return org.openqa.selenium.support.PageFactory.initElements(driver, pageClassToProxy);
    }

}
