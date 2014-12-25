package khppp.application.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Iryna_Perekhod on 12/10/2014.
 */
public class AddSubgroupTab extends Component{

    public AddSubgroupTab(WebDriver driver) {
        super(driver);
    }

    public void enterSubgroupName(String groupName) {
        WebElement subName = waitFor(xpath("//input[@class='form-control page_changer']"));
        typeInto(subName, groupName);
    }

    public void selectMentor(String mentorName) {
        Select sel = new Select(find(By.xpath("//select[@name='choosenMentors']")));
        sel.selectByVisibleText(mentorName);
    }

    public void chooseMentee(String menteeName) {
        Select sel = new Select(find(By.xpath("//select[@name='allMentees']")));
        sel.selectByVisibleText(menteeName);
    }

    public void clickAddBtn() {
       waitFor(xpath("//div[@class='btn btn-success btn-sm remove_user_btn add_option page_changer']")).click();
    }

    public void clickSaveBtn() {
        waitFor(xpath("//*[@id='create-group-btn']")).click();
    }

    public void clickRemoveBtn() {
        waitFor(xpath("//div[@class='btn btn-warning btn-sm remove_user_btn remove_option page_changer']")).click();
    }
}
