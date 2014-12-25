package khppp.tests;

import khppp.application.steps.AddUserSteps;
import khppp.application.steps.LoginSteps;
import khppp.application.steps.NavBarSteps;
import khppp.application.steps.UsersTabSteps;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;

import java.util.List;

import static khppp.application.Features.USERS;
import static khppp.excel.utils.ExcelColumn.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by Serhii_Pirohov on 19.11.2014.
 */
public class UsersTest extends BaseCase {

    LoginSteps loginSteps;
    AddUserSteps addUserSteps;
    NavBarSteps navBarSteps;
    UsersTabSteps usersTabSteps;

    @BeforeClass
    public void setUp() {
        loginSteps = new LoginSteps(pages);
        addUserSteps = new AddUserSteps(pages);
        navBarSteps = new NavBarSteps(pages);
        usersTabSteps = new UsersTabSteps(pages);
    }

    @DataProvider(name = "users")
    /*public Object[][] credentials(Method method) throws Exception {
        return testData(method, "Users");
	}*/

//    @Test(dataProvider = "users")
//    public void users(List<String> data) {
//        login(data);
//        navBarSteps.navigateTo("Users");
//        assertThat(usersTabSteps.getAllUsers().size(),
//                equalTo(Double.valueOf(data.get(EXPECTED)).intValue()));
//    }

    @Features(USERS)
    @Test(dataProvider = "users")
    public void addUserCustomEmail(List<String> data) {
        login(data);
        navBarSteps.navigateTo("Users");
        addUserSteps.addNewUserCustomEmail(data.get(NEW_USER_NAME), data.get(NEW_USER_SURNAME), data.get(NEW_USER_EMAIL));
        assertThat(usersTabSteps.userDisplayed(data.get(NEW_USER_SURNAME)), is(true));
        navBarSteps.logout();
    }



        /*--Admin creates Admin, Lab-Manager, Mentor, Mentee--*/

    @Features(USERS)
    @Test(dataProvider = "users")
    public void adminAddNewUser(List<String> data) {
        login(data);
        navBarSteps.navigateTo("Users");
        addUserSteps.addUserDifferentRoles(data.get(NEW_USER_NAME), data.get(NEW_USER_SURNAME), data.get(NEW_USER_ROLE));
        assertThat(usersTabSteps.userDisplayed(data.get(NEW_USER_SURNAME)), is(true));
        navBarSteps.logout();
    }

    /* Verify it is impossible to create user without name or surname */
    @Features(USERS)
    @Test(dataProvider = "users")
    public void addUserWithoutName(List<String> data) {
        login(data);
        navBarSteps.navigateTo("Users");
        addUserSteps.addNewUser(" ", data.get(NEW_USER_SURNAME));
        assertThat(addUserSteps.emptyNameFieldMessage(), is(data.get(EXPECTED_ERROR)));
        navBarSteps.logout();
    }

    @Features(USERS)
    @Test(dataProvider = "users")
    public void addUserWithoutSurname(List<String> data) {
        login(data);
        navBarSteps.navigateTo("Users");
        addUserSteps.addNewUser(data.get(USER_NAME), " ");
        assertThat(addUserSteps.emptySurnameFieldMessage(), is(data.get(EXPECTED_ERROR)));
        navBarSteps.logout();
    }

}
