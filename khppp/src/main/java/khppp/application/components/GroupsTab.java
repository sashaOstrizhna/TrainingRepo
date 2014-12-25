package khppp.application.components;

import khppp.application.entitites.Group;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleksandra_Ostrizhna on 11/28/2014.
 */
public class GroupsTab extends Component {

    public GroupsTab(WebDriver driver) {
        super(driver);
    }

    public WebElement getEditGroupBtn() {
        return waitFor(xpath("//tr[1]/td[7]/a"));
    }

    public WebElement getAddGroupBtn() {
        return waitFor(xpath("//button[@class='btn btn-success']"));
    }

    public void clickFirstGroup() {
        waitFor(xpath("//tbody/tr[1]/td[1]")).click();
    }

    public void clickFirstNotEmptyGroup() {
        waitFor(xpath(".//*[@id='table_group_journal']/tbody/tr/td[2][text()!=0]")).click();
    }

    public void clickGroupByName(String groupName){
        waitFor(xpath("//td[text()='%s']", groupName)).click();
    }

    public WebElement getExportBtn() {
        return waitFor(xpath(".//*[@id='create_csv_button']"));
    }

    public boolean groupTabNameDisplayed() {
        WebElement tabName = waitFor(xpath("//div[@class='page_header_text']"));
        return tabName.isDisplayed() && "Groups".equals(tabName.getText());
    }

    public boolean btnAddGroupDisplayed() {
        WebElement btnName = waitFor(xpath("//button[@class='btn btn-success']"));
        return btnName.isDisplayed() && "Add Group".equals(btnName.getText());
    }

    public boolean btnExportDisplayed() {
        WebElement btnName = waitFor(xpath(".//*[@id='create_csv_button']"));
        return btnName.isDisplayed() && "Export".equals(btnName.getText());
    }

    public boolean getGroupsTableHead(int numOfLabels) {
        ArrayList<WebElement> headTableNames = new ArrayList<>();
        headTableNames.add(waitFor(xpath("//tr/th[text()='Group name']")));
        headTableNames.add(waitFor(xpath("//tr/th[text()='Number of students']")));
        headTableNames.add(waitFor(xpath("//tr/th[text()='Department']")));
        headTableNames.add(waitFor(xpath("//tr/th[text()='Date of creation']")));
        headTableNames.add(waitFor(xpath("//tr/th[text()='Lab Manager']")));
        headTableNames.add(waitFor(xpath("//tr/th[text()='Status']")));
        headTableNames.add(waitFor(xpath("//tr/th[text()='Edit Group']")));
        return headTableNames.size() == numOfLabels;
    }

    public boolean createGroupDisplayed(String groupName) {
        return displayed(xpath("//td[text()='%s']", groupName));
    }

    public boolean groupWithMenteesDisplayed(String groupName, int numOfMentees) {
        boolean flag = false;
        List<WebElement> numsofMentees = waitForAll(By.xpath("//tr//td[2]"));
        List<WebElement> namesOfGroups = waitForAll(By.xpath("//td[1]"));
        int numOfRows = namesOfGroups.size();
        for (int i = 0; i < numOfRows; i++) {
            if (namesOfGroups.get(i).getText().equals(groupName) && Integer.valueOf(numsofMentees.get(i).getText()) == numOfMentees) {
                flag = true;
            }
        }
        return flag;
    }
}
