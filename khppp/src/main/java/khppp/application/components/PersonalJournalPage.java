package khppp.application.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.apache.commons.io.FileUtils.waitFor;
import static org.openqa.selenium.By.id;

/**
 * Created by Iryna_Perekhod on 11/28/2014.
 */
public class PersonalJournalPage extends Component{

    public PersonalJournalPage(WebDriver driver) {
        super(driver);
    }

    public void clickTaskName() {
        WebElement taskName = waitFor(xpath(".//*[@id='0']/td[1]"));
        taskName.click();
    }

    public void clickClosedBtn() {
        WebElement closedBtn = waitFor(xpath(".//*[@id='collapse0']/td[1]/a[1]"));
        closedBtn.click();
    }

    public void clickInProgressBtn() {
        WebElement inProgressBtn = waitFor(xpath(".//*[@id='collapse0']/td[1]/a[2]"));
        inProgressBtn.click();
    }

    public void clickResolvedBtn() {
        WebElement resolvedBtn = waitFor(xpath(".//*[@id='collapse0']/td[1]/a"));
        resolvedBtn.click();
    }

    public String checkStatus() {
        WebElement status = waitFor(xpath(".//tr[@id='0']/td[2]"));
        return status.getText();
    }




}
