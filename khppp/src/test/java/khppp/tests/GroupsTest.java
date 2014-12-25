package khppp.tests;

import khppp.application.steps.*;
import org.aspectj.lang.annotation.After;
import org.testng.annotations.*;
import ru.yandex.qatools.allure.annotations.Features;

import static khppp.application.Features.GROUP;

import java.util.List;
import static khppp.excel.utils.ExcelColumn.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by Oleksandra_Ostrizhna on 11/28/2014.
 */
public class GroupsTest extends BaseCase {

    LoginSteps loginSteps;
    AddGroupSteps addGroupSteps;
    NavBarSteps navBarSteps;
    GroupsTabSteps groupsTabSteps;
    AddUserSteps addUserSteps;
    UsersTabSteps usersTabSteps;

    @BeforeClass
    public void setUp() {
        loginSteps = new LoginSteps(pages);
        addGroupSteps = new AddGroupSteps(pages);
        navBarSteps = new NavBarSteps(pages);
        groupsTabSteps = new GroupsTabSteps(pages);
        addUserSteps = new AddUserSteps(pages);
        usersTabSteps = new UsersTabSteps(pages);
    }


    @Test(dataProvider = "testData", priority = 1)
    public void preConditions(List<String> data) {
        login(data);
    }

    @Test(dataProvider = "testData", dependsOnMethods = "preConditions", priority = 4)
    public void creationOfMentee(List<String> data) {
        navBarSteps.navigateTo("Users");
        addUserSteps.addUserDifferentRoles(data.get(NEW_USER_NAME), data.get(NEW_USER_SURNAME), data.get(NEW_USER_ROLE));
    }

    @Features(GROUP)
    @Test(priority = 2)
    public void validTabName() {
        goToGroupsTab();
        assertThat(groupsTabSteps.groupTabDisplayed(), is(true));
    }

    @Features(GROUP)
    @Test(priority = 2)
    public void addGroupBtnName() {
        goToGroupsTab();
        assertThat(groupsTabSteps.btnAddGroupDisplayed(), is(true));
    }

    @Features(GROUP)
    @Test(priority = 2)
    public void exportBtnName() {
        goToGroupsTab();
        assertThat(groupsTabSteps.btnExportDisplayed(), is(true));
    }

    @Features(GROUP)
    @Test(dataProvider = "testData", priority = 2)
    public void validGroupsTableHead(List<String> data) {
        goToGroupsTab();
        assertThat(groupsTabSteps.groupsTabTableHeadDisplayed(Integer.valueOf(data.get(NUMBER_OF_ELEMENTS))), is(true));
    }

    //************************AddGroup Tab Tests*************************
    //dfjgjdfgjdfgjd
    @Features(GROUP)
    @Test(dataProvider = "testData", dependsOnMethods = "creationOfMentee")
    public void displayGroupWithMentee(List<String> data) {
        goToGroupsTab();
        assertThat(groupsTabSteps.groupWithMenteeCreated(data.get(GROUP_NAME), Integer.valueOf(data.get(GROUP_MENTEE))), is(true));
    }

    @Features(GROUP)
    @Test(dependsOnMethods = "creationOfMentee")
    public void menteeInAvailableMenteesField() {
        goToGroupsTab();
        goToAddGroupsTab();
        assertThat(addGroupSteps.nameOfCreatedMenteeDisplayed(), is(true));
    }

    @Features(GROUP)
    @Test(dataProvider = "testData", priority = 3)
    public void addEmptyGroup(List<String> data) {
        goToGroupsTab();
        goToAddGroupsTab();
        addGroupSteps.addNewEmptyGroup(data.get(GROUP_NAME), data.get(DEPARTMENT_NAME));
        addGroupSteps.clickSaveBtn();
        assertThat(groupsTabSteps.emptyGroupCreated(data.get(GROUP_NAME)), is(true));
    }

    @Features(GROUP)
    @Test(dataProvider = "testData", dependsOnMethods = "menteeInAvailableMenteesField")
    public void createGroupWithMentee(List<String> data) {
        goToGroupsTab();
        goToAddGroupsTab();
        addGroupSteps.addNewGroupWithMentees(data.get(GROUP_NAME), data.get(DEPARTMENT_NAME), data.get(USER_NAME));
        assertThat(addGroupSteps.nameOfChosenMenteeDisplayed(), is(true));
    }

    @Features(GROUP)
    @Test(dependsOnMethods = "createGroupWithMentee")
    public void removeMenteeFromGroup() {
        addGroupSteps.clickRemoveMenteeBtn();
        addGroupSteps.clickSaveBtn();
        assertThat(addGroupSteps.nameOfCreatedMenteeDisplayed(), is(true));
    }

    @Features(GROUP)
    @Test(dataProvider = "testData", priority = 3)
    public void addGroupWithoutName(List<String> data) {
        goToGroupsTab();
        goToAddGroupsTab();
        addGroupSteps.addNewEmptyGroupWithoutName(data.get(DEPARTMENT_NAME));
        addGroupSteps.clickSaveBtn();
        assertThat(addGroupSteps.errorEmptyGroupNameDisplayed(), is(true));
    }

    @Features(GROUP)
    @Test(dataProvider = "testData", priority = 3)
    public void addGroupWithoutDep(List<String> data) {
        goToGroupsTab();
        goToAddGroupsTab();
        addGroupSteps.addNewEmptyGroup(data.get(GROUP_NAME), data.get(DEPARTMENT_NAME));
        addGroupSteps.clickSaveBtn();
        assertThat(addGroupSteps.errorNotSelectedDepDisplayed(), is(true));
    }

    @Features(GROUP)
    @Test(priority = 3)
    public void validAddGroupTabName() {
        goToGroupsTab();
        goToAddGroupsTab();
        assertThat(addGroupSteps.addGroupTabDisplayed(), is(true));
    }

    @Features(GROUP)
    @Test(dataProvider = "testData", priority = 3)
    public void verifyLabels(List<String> data) {
        goToGroupsTab();
        goToAddGroupsTab();
        assertThat(addGroupSteps.allLabelsAreCorrect(Integer.valueOf(data.get(NUMBER_OF_ELEMENTS))), is(true));
    }

    @Features(GROUP)
    @Test(priority = 3)
    public void verifyButtonsDisplayed() {
        goToGroupsTab();
        goToAddGroupsTab();
        assertThat(addGroupSteps.allButtonsAreDisplayed(), is(true));
    }

    @Features(GROUP)
    @Test(priority = 3)
    public void verifyGroupNameField() {
        goToGroupsTab();
        goToAddGroupsTab();
        assertThat(addGroupSteps.groupNameFieldDisplayed(), is(true));
    }

    @Features(GROUP)
    @Test(dataProvider = "testData", priority = 3)
    public void groupNameFieldOneSymbol(List<String> data) {
        goToGroupsTab();
        goToAddGroupsTab();
        addGroupSteps.addNewEmptyGroup(data.get(GROUP_NAME), data.get(DEPARTMENT_NAME));
        addGroupSteps.clickSaveBtn();
        assertThat(addGroupSteps.errorIncorrectlyGroupNameDisplayed(), is(true));
    }

    @Features(GROUP)
    @Test(dataProvider = "testData", priority = 3)
    public void groupNameFieldFromSpecialSymbol(List<String> data) {
        goToGroupsTab();
        goToAddGroupsTab();
        addGroupSteps.addNewEmptyGroup(data.get(GROUP_NAME), data.get(DEPARTMENT_NAME));
        addGroupSteps.clickSaveBtn();
        assertThat(addGroupSteps.errorIncorrectlyGroupNameDisplayed(), is(true));
    }

    @AfterClass
    public void logout() {
        navBarSteps.logout();
    }
}