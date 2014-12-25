package khppp.application.steps;

import khppp.application.components.GroupsTab;
import khppp.application.components.NavBar;
import khppp.factory.PageFactory;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Serhii_Pirohov on 18.11.2014.
 */
public class NavBarSteps {

    NavBar navBar;
    GroupsTab groupsTab;

    public NavBarSteps(PageFactory factory) {
        this.navBar = factory.createPage(NavBar.class);
        this.groupsTab = factory.createPage(GroupsTab.class);
    }

    @Step("Then get logged user name")
    public String loggedUserName() {
        return navBar.getUserName().getText();
    }

    @Step("When I navigate to groups")
    public void navigateToGroups() {
        navBar.getTab("Groups").click();
    }

    @Step("When I navigate to {0}")
    public void navigateTo(String tabName) {
        navBar.getTab(tabName).click();
    }

    public void logout() {
        navBar.getLogoutBtn().click();
    }


}
