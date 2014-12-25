package khppp.application.steps;

import khppp.application.components.UsersTab;
import khppp.application.entitites.User;
import khppp.factory.PageFactory;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Serhii_Pirohov on 18.11.2014.
 */
public class UsersTabSteps {

    UsersTab usersTab;

    public UsersTabSteps(PageFactory factory){
        this.usersTab = factory.createPage(UsersTab.class);
    }

    public void clickAddUsers(){
        usersTab.getAddUsersBtn().click();
    }

    public List<User> getAllUsers() {
       return usersTab.getAllUsers();
    }

    public boolean userDisplayed(String name){
        return usersTab.isCreateUserDisplayed(name);
    }

    public WebElement getFirstUser(String name){
        return usersTab.getFirstUser(name);
    }
}
