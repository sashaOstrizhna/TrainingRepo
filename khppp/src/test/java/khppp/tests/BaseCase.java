package khppp.tests;

import khppp.application.steps.GroupsTabSteps;
import khppp.application.steps.LoginSteps;
import khppp.application.steps.NavBarSteps;
import khppp.core.CoreTest;

import khppp.custom.listeners.CustomListener;
import khppp.custom.reporter.CustomReport;
import khppp.factory.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import static khppp.excel.utils.ExcelColumn.USER_NAME;
import static khppp.excel.utils.ExcelColumn.USER_PASS;

/**
 * Created by Sergey on 02.11.2014.
 */
@Listeners(value = {CustomListener.class, CustomReport.class})
public abstract class BaseCase {

    public static final String DEFAULT_BROWSER = "firefox";
    CoreTest coreTest;
    PageFactory pages;
    LoginSteps loginSteps;
    NavBarSteps navBarSteps;
    GroupsTabSteps groupsTabSteps;

    @BeforeClass
    public void configure() throws IOException {
        coreTest = new CoreTest();
        coreTest.setUpDriver(System.getProperty("browser", DEFAULT_BROWSER));
        pages = coreTest.getFactory();
        loginSteps = new LoginSteps(pages);
        navBarSteps = new NavBarSteps(pages);
        groupsTabSteps = new GroupsTabSteps(pages);
    }

    @AfterClass
    public void shutDown() {
        coreTest.shutDown();
    }

    @DataProvider(name = "testData")
    public Object[][] testData(Method method) throws Exception {
        String sheet = method.getDeclaringClass().getSimpleName();
        return coreTest.testData(method, sheet);
    }

    protected void open() {
        coreTest.open();
    }

    protected void login(List<String> data) {
        open();
        loginSteps.login(data.get(USER_NAME), data.get(USER_PASS));
    }

    protected void goToGroupsTab() {
        navBarSteps.navigateToGroups();
    }

    protected void goToAddGroupsTab() {
        goToGroupsTab();
        groupsTabSteps.goToAddGroupTab();
    }
}