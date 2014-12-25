package khppp.application.components;

import khppp.application.dialogs.AbstractDialog;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Oleksandra_Ostrizhna on 12/18/2014.
 */
public class AssignTaskDialog extends Component {

    public AssignTaskDialog(WebDriver driver) {
        super(driver);
    }

    public boolean getPopUpWindowName(String popUpName) {
        return waitFor(xpath("//*[@id='myModalLabel']")).getText().equals(popUpName);
    }

    public WebElement getStartDateField() {
        return waitFor(xpath("//input[@name='startDate']"));
    }

    public WebElement getDeadlineField() {
        return waitFor(xpath("//input[@name='finishDate']"));
    }

    public WebElement getMarkDescriptionField() {
        return waitFor(xpath("//input[@name='mark_description']"));
    }

    public WebElement getPenaltyField() {
        return waitFor(xpath("//input[@name='penalti']"));
    }

    public WebElement getMarkCheckbox() {
        return waitFor(xpath("//input[@name='mark_description_option']"));
    }

    public WebElement getFeedbackCheckbox() {
        return waitFor(xpath("//input[@name='feedback_option']"));
    }

    public WebElement getPenaltyCheckbox() {
        return waitFor(xpath("//input[@name='penalti_option']"));
    }


    public boolean labelsFromPopUpDisplayedCorrectly(int numOfLabels) {
        ArrayList<WebElement> labels = new ArrayList<>();
        labels.add(waitFor(xpath(".//*[@id='myModalLabel'][text()='Assign Task']")));
        labels.add(waitFor(xpath(".//*[@id='startDate']/label[text()='Start date ']")));
        labels.add(waitFor(xpath(".//*[@id='finishDate']/label[text()='Deadline:']")));
        labels.add(waitFor(xpath("//label[text()='Mark']")));
        labels.add(waitFor(xpath("//label[text()='Feedback']")));
        labels.add(waitFor(xpath("//label[text()='Penalty']")));
        return labels.size() == numOfLabels;
    }

    public boolean buttonsFromPopUpDisplayedCorrectly(int numOfButtons) {
        ArrayList<WebElement> buttons = new ArrayList<>();
        buttons.add(waitFor(xpath("//button[text()='Cancel']")));
        buttons.add(waitFor(xpath("//button[text()='Ok']")));
        buttons.add(waitFor(xpath("//button[text()='x']")));
        return buttons.size() == numOfButtons;
    }

    public boolean getAllFieldsFromAssignTaskPopUp() {
        return getStartDateField().isDisplayed() && getDeadlineField().isDisplayed() && getMarkDescriptionField().isDisplayed() && getPenaltyField().isDisplayed();
    }

    public boolean getAllCheckboxesFromAssignTaskPopUp() {
        return getMarkCheckbox().isDisplayed() && getFeedbackCheckbox().isDisplayed() && getPenaltyCheckbox().isDisplayed();
    }
}
