package khppp.tests;

import khppp.application.steps.*;
import khppp.excel.utils.ExcelColumn;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;

import java.util.List;

import static khppp.excel.utils.ExcelColumn.*;
import static khppp.application.Features.ASSIGN_TASK;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by Oleksandra_Ostrizhna on 12/17/2014.
 */
public class AssignTasksTest extends BaseCase {

    LoginSteps loginSteps;
    NavBarSteps navBarSteps;
    GroupsTabSteps groupsTabSteps;
    GroupJournalSteps groupJournalSteps;
    AssignTasksSteps assignTasksSteps;

    @BeforeClass
    public void setUp() {
        loginSteps = new LoginSteps(pages);
        navBarSteps = new NavBarSteps(pages);
        groupsTabSteps = new GroupsTabSteps(pages);
        groupJournalSteps = new GroupJournalSteps(pages);
        assignTasksSteps = new AssignTasksSteps(pages);
    }


    @Test(dataProvider = "testData", priority = 1)
    public void preConditions(List<String> data) {
        login(data);
        goToGroupsTab();
        groupsTabSteps.goToNotEmptyGroup();
        assignTasksSteps.assignTaskToOneMentee();
    }

    @Features(ASSIGN_TASK)
    @Test(dependsOnMethods = "preConditions", priority = 2)
    public void isOnAssignTaskTab() {
        assertThat(assignTasksSteps.onAssignTaskTab(), is(true));
    }

    @Features(ASSIGN_TASK)
    @Test(dataProvider = "testData", priority = 2)
    public void allLabelsOnAssignTaskTab(List<String> data) {
        assertThat(assignTasksSteps.allLabelsOnAssignTaskTab(Integer.valueOf(data.get(NUMBER_OF_ELEMENTS))), is(true));
    }

    @Features(ASSIGN_TASK)
    @Test(priority = 2)
    public void allSelectsOnAssignTaskTab() {
        assertThat(assignTasksSteps.allSelectsOnAssignTaskTab(), is(true));
    }

    @Features(ASSIGN_TASK)
    @Test(priority = 2)
    public void allButtonsOnAssignTaskTab() {
        assertThat(assignTasksSteps.allButtonsOnAssignTaskTab(), is(true));
    }

    @Features(ASSIGN_TASK)
    @Test(dataProvider = "testData", priority = 3)
    public void isOnAssignTaskPopUp(List<String> data) {
        assignTasksSteps.getPopUpAssignTask(data.get(TASK_TYPE), data.get(DEPARTMENT_NAME), data.get(TASK_NAME));
        assertThat(assignTasksSteps.popUpAssingTaskAppears(data.get(NAME_OF_TAB)), is(true));
    }

    @Features(ASSIGN_TASK)
    @Test(dataProvider = "testData", priority = 4)
    public void allLabelsOnAssignTaskPopUp(List<String> data) {
        assertThat(assignTasksSteps.allLabelsOnAssignTaskPopUp(Integer.valueOf(data.get(NUMBER_OF_ELEMENTS))), is(true));
    }

    @Features(ASSIGN_TASK)
    @Test(priority = 4)
    public void allFieldsOnAssignTaskPopUp() {
        assertThat(assignTasksSteps.allFieldsOnAssignTaskPopUp(), is(true));
    }

    @Features(ASSIGN_TASK)
    @Test(dataProvider = "testData", priority = 4)
    public void allButtonsOnAssignTaskPopUp(List<String> data) {
        assertThat(assignTasksSteps.allButtonsOnAssignTaskPopUp(Integer.valueOf(data.get(NUMBER_OF_ELEMENTS))), is(true));
    }

    @Features(ASSIGN_TASK)
    @Test(priority = 4)
    public void allCheckboxesOnAssignTaskPopUp() {
        assertThat(assignTasksSteps.allCheckboxesOnAssignTaskPopUp(), is(true));
    }

    @Features(ASSIGN_TASK)
    @Test(dataProvider = "testData", dependsOnMethods = "isOnAssignTaskTab")
    public void menteesAreDisplayedInSelectedMenteesField(List<String> data) {
        assertThat(assignTasksSteps.menteeIsDisplayedInSelectedMenteesField(data.get(MENTEE_NAME)), is(true));
    }
}
