package khppp.application.steps;

import khppp.application.components.AssignTasksTab;
import khppp.application.components.GroupJournalPage;
import khppp.application.components.GroupsTab;
import khppp.application.components.AssignTaskDialog;
import khppp.factory.PageFactory;

/**
 * Created by Oleksandra_Ostrizhna on 12/18/2014.
 */
public class AssignTasksSteps {

    AssignTasksTab assignTasksTab;
    GroupsTab groupsTab;
    GroupJournalPage groupJournalPage;
    AssignTaskDialog assignTaskDialog;

    public AssignTasksSteps(PageFactory factory) {
        this.assignTasksTab = factory.createPage(AssignTasksTab.class);
        this.groupsTab = factory.createPage(GroupsTab.class);
        this.groupJournalPage = factory.createPage(GroupJournalPage.class);
        this.assignTaskDialog = factory.createPage(AssignTaskDialog.class);
    }

    public void assignTaskToOneMentee() {
        groupJournalPage.clickFirstSubGroup();
        groupJournalPage.selectFirstCheckboxInSubGroup();
        groupJournalPage.clickAssignBtn();
    }

    public void getPopUpAssignTask(String taskType, String taskDepartment, String assignTask) {
        assignTasksTab.selectTaskType(taskType);
        assignTasksTab.selectTaskDepartment(taskDepartment);
        assignTasksTab.selectAssignTasks(assignTask);
        assignTasksTab.getAddBtn().click();
    }

    public boolean popUpAssingTaskAppears(String popUp) {
        return assignTaskDialog.getPopUpWindowName(popUp);
    }

    public boolean menteeIsDisplayedInSelectedMenteesField(String menteeName) {
        return assignTasksTab.selectedMenteesFieldContainsCorrectlyInf(menteeName);
    }


    public boolean allLabelsOnAssignTaskPopUp(int numOfLabels) {
        return assignTaskDialog.labelsFromPopUpDisplayedCorrectly(numOfLabels);
    }

    public boolean allButtonsOnAssignTaskPopUp(int numOfButtons) {
        return assignTaskDialog.buttonsFromPopUpDisplayedCorrectly(numOfButtons);
    }

    public boolean allFieldsOnAssignTaskPopUp() {
        return assignTaskDialog.getAllFieldsFromAssignTaskPopUp();
    }

    public boolean allCheckboxesOnAssignTaskPopUp() {
        return assignTaskDialog.getAllCheckboxesFromAssignTaskPopUp();
    }

    public boolean onAssignTaskTab() {
        return assignTasksTab.assignTasksTabNameDisplayed();
    }

    public boolean allLabelsOnAssignTaskTab(int numOfLabels) {
        return assignTasksTab.labelsDisplayedCorrectly(numOfLabels);
    }

    public boolean allButtonsOnAssignTaskTab() {
        return assignTasksTab.buttonsDisplayedCorrectly();
    }

    public boolean allSelectsOnAssignTaskTab() {
        return assignTasksTab.getAllSelectsFromAssignTaskTab();
    }

}
