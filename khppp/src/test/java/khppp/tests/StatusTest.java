package khppp.tests;

import khppp.application.steps.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;

import java.lang.reflect.Method;
import java.util.List;

import static khppp.excel.utils.ExcelColumn.*;

import static khppp.application.Features.STATUS;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by Iryna_Perekhod on 11/28/2014.
 */
public class StatusTest extends BaseCase {

    LoginSteps loginSteps;
    AddUserSteps addUserSteps;
    NavBarSteps navBarSteps;
    UsersTabSteps usersTabSteps;
    StatusSteps statusSteps;

    @BeforeClass
    public void setUp() {
        loginSteps = new LoginSteps(pages);
        addUserSteps = new AddUserSteps(pages);
        navBarSteps = new NavBarSteps(pages);
        usersTabSteps = new UsersTabSteps(pages);
        statusSteps = new StatusSteps(pages);
    }

    @Test(dataProvider = "testData")
    public void preConditionsMentor(List<String> data) {
        login(data);
    }

    @Test(dataProvider = "testData")
    public void preConditionsMentee(List<String> data) {
        login(data);
    }

    @Features(STATUS)
    @Test(dataProvider = "testData", dependsOnMethods = "preConditionsMentor")
    public void changeStatusByMentor(List<String> data) {

        navBarSteps.navigateTo("Users");
        usersTabSteps.getFirstUser(data.get(USER_NAME)).click();
        statusSteps.clickTaskNameStep();
        statusSteps.clickCloseBtnStep();
        assertThat(statusSteps.statusChanged("Closed"), is(true));
        statusSteps.clickTaskNameStep();
        statusSteps.clickInProgressBtnStep();
        navBarSteps.logout();
        assertThat(statusSteps.statusChanged("In progress"), is(true));
    }

    @Test(dependsOnMethods = "preConditionsMentee")
    public void changeStatusByMentee() {
        statusSteps.clickTaskNameStep();
        statusSteps.clickResolvedBtn();
        navBarSteps.logout();
        assertThat(statusSteps.statusChanged("Resolved"), is(true));
    }

}
