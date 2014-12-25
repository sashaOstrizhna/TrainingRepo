package khppp.application.components;

import khppp.application.entitites.Subgroup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.By.id;


public class GroupJournalPage extends Component {

    public GroupJournalPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddSubgroupBtn() {
        WebElement addSubgroupBtn = waitFor(By.xpath("//div[@class='submenu']/a[text()='Add Subgroup']"));
        addSubgroupBtn.click();
    }

    public void clickGroupTasksTab() {waitFor(xpath("//a[text()='GroupTasks']")).click();}

    public void clickFirstSubGroup() {
        WebElement firstSubgroupFromList = waitFor(xpath(".//*[@id='table_body']/tr[1]/td[2]"));
        firstSubgroupFromList.click();
    }

    public void selectFirstCheckboxInSubGroup() {
        WebElement checkBox = waitFor(xpath(".//*[@id='table_body']/tr[2]/td[1]/input"));
        checkBox.click();
    }

    public void clickAssignBtn() {
        WebElement assignBtn = waitFor(xpath("//a[@class='btn btn-success'][text()='Assign']"));
        assignBtn.click();
    }

    public List<Subgroup> getAllSubgroups() {
        int numberOfRows = waitForAll(xpath("//*[@id='table_group_journal']//tr")).size();
        System.out.println("ROWS " + numberOfRows);
        List<Subgroup> subgroups = new ArrayList<>();
        for (int i = 3; i < numberOfRows - 1; i++) {
            List<WebElement> columns = findAll(xpath(
                    "//*[@id='table_group_journal']//tr[%s]//td", i));
            Subgroup subgroup = new Subgroup();
            subgroup.setSubName(columns.get(1).getText());
            subgroup.setSubMentor(columns.get(3).getText());
            subgroups.add(subgroup);
        }
        return subgroups;
    }

    public boolean isCreatedSubgroupDisplayed(String subName) {
        return displayed(xpath("//td[contains(.,'%s')][2]", subName));
    }

    public boolean isEmptySignDisplayed(String subName) {
        return displayed(xpath("//td[contains(.,'%s')][2]/span[@class='badge']", subName));
    }

    public WebElement getAddSubgroupButton() {
        return waitFor(xpath("//div[@class='submenu']/a[text()='Add Subgroup']"));
    }

    public boolean isPageNameDisplayed() {
        WebElement pageName = waitFor(xpath(".//span[text()='Group Journal']"));
        return pageName.isDisplayed() && "Group Journal".equals(pageName.getText());
    }

    public boolean isGroupNameDisplayed() {
        WebElement groupName = waitFor(xpath("./*//*[@id='group_name']"));
        return groupName.isDisplayed();
    }

    public boolean isBtnAddSubgroupDisplayed() {
        WebElement btnAddSubgroup = waitFor(xpath("//div[@class='submenu']/a[text()='Add Subgroup']"));
        return btnAddSubgroup.isDisplayed() && "Add Subgroup".equals(btnAddSubgroup.getText());
    }

    public boolean isBtnAssignDisplayed() {
        WebElement btnAssign = waitFor(xpath("//a[@class='btn btn-success'][2]"));
        return btnAssign.isDisplayed() && "Assign".equals(btnAssign.getText());
    }

    public boolean isBtnExportDisplayed() {
        WebElement btnExport = waitFor(id("create_csv_button"));
        return btnExport.isDisplayed() && "Export".equals(btnExport.getText());
    }

    public boolean isBtnBackDisplayed() {
        WebElement btnBack = waitFor(xpath(" .//*[@id='group_journal_submit']/div[2]/a"));
        return btnBack.isDisplayed() && "Back".equals(btnBack.getText());
    }

        /*public boolean isCreatedSubgroupDisplayed(String subName) {
            return displayed(xpath("//td[contains(.,'%s')][2]", subName));
        }

        public boolean isEmptySignDisplayed(String subName) {
            return displayed(xpath("//td[contains(.,'%s')][2]/span[@class='badge']", subName));
        }*/

}
