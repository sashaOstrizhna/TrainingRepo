package khppp.tests;

import khppp.application.steps.NavBarSteps;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;

import java.util.List;

import static khppp.application.Features.LOGIN;
import static khppp.excel.utils.ExcelColumn.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

/**
 * Created by Serhii_Pirohov on 18.11.2014.
 */
public class LoginTest extends BaseCase {
    /*NavBarSteps navBarSteps;

	/*@DataProvider(name = "authentication")
	public Object[][] credentials(Method method) throws Exception {
		return testData(method, "Login");
	}*/

    @BeforeClass
    public void setUp() {
        navBarSteps = new NavBarSteps(pages);
    }

    @Features(LOGIN)
    @Test(dataProvider = "authentication")
    public void userLogin(List<String> data) {
        open();
        loginSteps.login(data.get(USER_NAME), data.get(USER_PASS));
        String loggedUserName = navBarSteps.loggedUserName();
        navBarSteps.navigateTo("Logout");
        assertThat(loggedUserName, equalTo(data.get(EXPECTED)));
    }

    @Features(LOGIN)
    @Test(dataProvider = "authentication")
    public void userIncorrectLogin(List<String> data) {
        open();
        loginSteps.login(data.get(USER_NAME), data.get(USER_PASS));
        assertThat(loginSteps.incorrectLoginPassword(), is(data.get(EXPECTED)));
    }

    @Features(LOGIN)
    @Test(dataProvider = "authentication")
    public void userEmptyLogin(List<String> data) {
        open();
        loginSteps.login(" ", data.get(USER_PASS));
        assertThat(loginSteps.incorrectLoginPassword(), is(data.get(EXPECTED)));
    }

    @Features(LOGIN)
    @Test(dataProvider = "authentication")
    public void userEmptyPassword(List<String> data) {
        open();
        loginSteps.login(data.get(USER_NAME), " ");
        assertThat(loginSteps.incorrectLoginPassword(), is(data.get(EXPECTED)));
    }
}
