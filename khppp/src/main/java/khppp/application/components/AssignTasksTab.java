package khppp.application.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Oleksandra_Ostrizhna on 12/17/2014.
 */
public class AssignTasksTab extends Component {

    public AssignTasksTab(WebDriver driver) {
        super(driver);
    }

    public boolean assignTasksTabNameDisplayed() {
        WebElement tabName = waitFor(xpath("//div[@class='page_header_text']"));
        return tabName.isDisplayed() && "Assign Tasks".equals(tabName.getText());
    }

    public WebElement getAddBtn() {
        return waitFor(xpath("//div[@id='add_task_button']"));
    }

    public WebElement getRemoveBtn() {
        return waitFor(xpath("//div[@class='btn btn-warning btn remove_user_btn remove_option']"));
    }

    public WebElement getSaveBtn() {
        return waitFor(xpath("//button[@id='saveButton']"));
    }

    public WebElement getTaskTypeSelect() {
        return waitFor(xpath("//select[@name='taskType']"));
    }

    public WebElement getTaskDepartmentSelect() {
        return waitFor(xpath("//select[@name='departmentId']"));
    }

    public WebElement getAssignTasksSelect() {
        return waitFor(xpath("//select[@id='tasks']"));
    }

    public WebElement getSelectedMenteesField() {
        return waitFor(xpath("//div[@class='row options_container margin-top-10px body-wrapper-assign col-md-4']"));
    }

    public WebElement getGroupTasksTable() {
        return waitFor(xpath("//table[@id='table_group_journal']"));
    }

    public void selectTaskType(String name) {
        Select sel = new Select(find(By.xpath("//select[@name='taskType']")));
        sel.selectByVisibleText(name);
    }

    public void selectTaskDepartment(String name) {
        Select sel = new Select(find(By.xpath("//select[@name='departmentId']")));
        sel.selectByVisibleText(name);
    }

    public void selectAssignTasks(String name) {
        Select sel = new Select(find(By.xpath("//select[@id='tasks']")));
        sel.selectByVisibleText(name);
    }

    public boolean buttonsDisplayedCorrectly() {
        ArrayList<String> buttons = new ArrayList<>();
        ArrayList<String> btnCorrectNames = new ArrayList<>(Arrays.asList("Add >", "< Remove", "Save"));
        buttons.add(waitFor(xpath("//div[@id='add_task_button']")).getText());
        buttons.add(waitFor(xpath("//div[@class='btn btn-warning btn remove_user_btn remove_option']")).getText());
        buttons.add(waitFor(xpath("//button[@id='saveButton']")).getText());
        return btnCorrectNames.equals(buttons);
    }

    public boolean labelsDisplayedCorrectly(int numOfLabels) {
        ArrayList<WebElement> labels = new ArrayList<>();
        labels.add(waitFor(xpath("//label[text()='Task type']")));
        labels.add(waitFor(xpath("//label[text()='Task department']")));
        labels.add(waitFor(xpath("//label[text()='Assign tasks']")));
        return labels.size() == numOfLabels;
    }

    public boolean getAllSelectsFromAssignTaskTab() {
        return getTaskTypeSelect().isDisplayed() && getTaskDepartmentSelect().isDisplayed() && getAssignTasksSelect().isDisplayed() && getSelectedMenteesField().isDisplayed() && getGroupTasksTable().isDisplayed();
    }

    public boolean selectedMenteesFieldContainsCorrectlyInf(String menteeName) {
        return menteeName.equalsIgnoreCase(waitFor(xpath("//div[@class='col-md-4 wrapper-div']//li/ul/li")).getText());
    }
}
