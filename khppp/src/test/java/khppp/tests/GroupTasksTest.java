package khppp.tests;

import khppp.application.components.GroupTasksPage;
import static khppp.excel.utils.ExcelColumn.*;
import khppp.application.steps.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;

import java.util.List;

import static khppp.application.Features.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by Iryna_Perekhod on 12/18/2014.
 */
public class GroupTasksTest extends BaseCase {

    LoginSteps loginSteps;
    GroupTasksSteps groupTasksSteps;
    GroupTasksPage groupTasksPage;

    @BeforeClass
    public void setUp() {
        loginSteps = new LoginSteps(pages);
        groupTasksSteps = new GroupTasksSteps(pages);
    }

    @Test(dataProvider = "testData", priority = 1)
    public void preConditions(List<String> data) {
        login(data);
    }

//    @Features(GROUP_TASKS_PAGE)
//    @Test(priority = 2)
//    public void sortByNameCheck() {
//        groupTasksSteps.goToGroupTasksPage();
//        assertThat(groupTasksSteps.isSortedByTaskName(), is(true));
//    }

    @Features(FILTER)
    @Test(dataProvider = "testData", priority = 2)
    public void filtByNameCheck(List<String> data) {
        groupTasksSteps.goToGroupTasksPage();
        assertThat(groupTasksSteps.isFilteredByTaskName(data.get(TASK_NAME)), is(true));
    }

    @AfterClass
    public void logout() {
        navBarSteps.logout();
    }
}
