package khppp.tests;

import khppp.application.steps.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;

import java.util.List;

import static khppp.application.Features.GROUP_JOURNAL;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by Anastasiia_Borodaiev on 12/4/2014.
 */
public class GroupJournalTests extends BaseCase {
    LoginSteps loginSteps;
    NavBarSteps navBarSteps;
    GroupsTabSteps groupsTabSteps;
    AddGroupSteps addGroupSteps;
    GroupJournalSteps groupJournalSteps;

    @BeforeClass
    public void setUp() {
        loginSteps = new LoginSteps(pages);
        addGroupSteps = new AddGroupSteps(pages);
        navBarSteps = new NavBarSteps(pages);
        groupsTabSteps = new GroupsTabSteps(pages);
        groupJournalSteps = new GroupJournalSteps(pages);
    }

    @Test(dataProvider = "testData")
    public void preConditions(List<String> data) {
        login(data);
        groupsTabSteps.goToGroupJournalPAge();
    }

    @Features(GROUP_JOURNAL)
    @Test(dependsOnMethods = "preConditions")
    public void correctPageName() {
        assertThat(groupJournalSteps.isGroupJournalDisplayed(), is(true));
    }

    @Features(GROUP_JOURNAL)
    @Test(dependsOnMethods = "preConditions")
    public void correctGroupName() {
        assertThat(groupJournalSteps.isGroupDisplayed(), is(true));
    }

    @Features(GROUP_JOURNAL)
    @Test(dependsOnMethods = "preConditions")
    public void addSubgroupBtnName() {
        assertThat(groupJournalSteps.isAddSubgroupDisplayed(), is(true));
    }

    @Features(GROUP_JOURNAL)
    @Test(dependsOnMethods = "preConditions")
    public void assignBtnName() {
        assertThat(groupJournalSteps.isAssignDisplayed(), is(true));
    }

    @Features(GROUP_JOURNAL)
    @Test(dependsOnMethods = "preConditions")
    public void exportBtnName() {
        assertThat(groupJournalSteps.isExportDisplayed(), is(true));
    }

    @Features(GROUP_JOURNAL)
    @Test(dependsOnMethods = "preConditions")
    public void backBtnName() {
        assertThat(groupJournalSteps.isBackDisplayed(), is(true));
    }

    @AfterClass
    public void logout() {
        navBarSteps.logout();
    }
}

