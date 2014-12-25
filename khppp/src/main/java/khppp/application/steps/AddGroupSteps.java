package khppp.application.steps;

import khppp.application.components.*;
import khppp.factory.PageFactory;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Oleksandra_Ostrizhna on 11/28/2014.
 */
public class AddGroupSteps {
    GroupsTab groupsTab;
    AddGroupTab addGroupTab;
    NavBar navBar;

    public AddGroupSteps(PageFactory factory) {
        this.groupsTab = factory.createPage(GroupsTab.class);
        this.addGroupTab = factory.createPage(AddGroupTab.class);
        this.navBar = factory.createPage(NavBar.class);
    }

    @Step("When I add new group {0},{1}")
    public void addNewEmptyGroup(String gName, String depName) {
        addGroupTab.enterGroupName(gName);
        addGroupTab.selectDepartment(depName);
    }

    public void addNewEmptyGroupWithoutName(String depName) {
        addGroupTab.selectDepartment(depName);
    }


    public void addNewGroupWithMentees(String gName, String depName, String menteeName) {
        addGroupTab.enterGroupName(gName);
        addGroupTab.selectDepartment(depName);
        addGroupTab.selectMentees(menteeName);
        addGroupTab.getAddBtn().click();
    }


    public void clickRemoveMenteeBtn() {
        addGroupTab.getRemoveBtn().click();
    }

    public void clickSaveBtn() {
        addGroupTab.getSaveBtn().click();
    }

    public boolean nameOfChosenMenteeDisplayed() {
        return addGroupTab.chosenMenteeDisplayed();
    }

    public boolean nameOfCreatedMenteeDisplayed() {
        return addGroupTab.createdMenteeDisplayed();
    }

    public boolean addGroupTabDisplayed() {
        return addGroupTab.addGroupTabNameDisplayed();
    }

    public boolean groupNameFieldDisplayed() {
        return addGroupTab.groupNameFieldDisplayed();
    }

    public boolean errorEmptyGroupNameDisplayed() {
        return addGroupTab.errorEmptyGroupNameDisplayed();
    }

    public boolean errorNotSelectedDepDisplayed() {
        return addGroupTab.errorNotSelectedDepDisplayed();
    }

    public boolean allLabelsAreCorrect(int numOfLabels) {
        return addGroupTab.labelsDisplayedCorrectly(numOfLabels);
    }

    public boolean errorIncorrectlyGroupNameDisplayed() {
        return addGroupTab.errorOneSymbolInGroupNameDisplayed();
    }

    public boolean allButtonsAreDisplayed() {
        return addGroupTab.getAddBtn().isDisplayed() && addGroupTab.getRemoveBtn().isDisplayed() && addGroupTab.getSaveBtn().isDisplayed();
    }
}
