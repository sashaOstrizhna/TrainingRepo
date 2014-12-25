package khppp.tests;

import khppp.application.steps.*;
import org.testng.annotations.*;
import ru.yandex.qatools.allure.annotations.Features;
import static khppp.excel.utils.ExcelColumn.*;
import java.util.List;

import static khppp.application.Features.SUBGROUP;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by Iryna_Perekhod on 12/10/2014.
 */
public class SubgroupTest extends BaseCase {

    LoginSteps loginSteps;
    AddSubgroupSteps addSubgroupSteps;
    NavBarSteps navBarSteps;
    GroupsTabSteps groupsTabSteps;
    GroupJournalSteps groupJournalSteps;

    @BeforeClass
    public void setUp() {
        loginSteps = new LoginSteps(pages);
        addSubgroupSteps = new AddSubgroupSteps(pages);
        navBarSteps = new NavBarSteps(pages);
        groupsTabSteps = new GroupsTabSteps(pages);
        groupJournalSteps = new GroupJournalSteps(pages);
    }

    @Test(dataProvider = "testData")
    public void preConditions(List<String> data) {
        login(data);
    }

    @Features(SUBGROUP)
    @Test(dataProvider = "testData", dependsOnMethods = "preConditions")
    public void addNewEmptySubgroup(List<String> data) {
        addSubgroupSteps.addNewEmptySubgroup(data.get(SUBGROUP_NAME));
        assertThat(groupJournalSteps.isEmptyGroupJournalDisplayed(), is(true));
    }

    @Features(SUBGROUP)
    @Test(dataProvider = "testData", dependsOnMethods = "preConditions")
    public void addNewSubgroup(List<String> data) {
        addSubgroupSteps.addNewSubgroup(data.get(SUBGROUP_NAME));
        assertThat(groupJournalSteps.isGroupJournalDisplayedI(), is(true));
    }

    @AfterClass
    public void logout() {
        navBarSteps.logout();
    }
}
