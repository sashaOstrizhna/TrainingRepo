package khppp.application.steps;

import khppp.application.components.AddUserTab;
import khppp.application.components.UsersTab;
import khppp.factory.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Serhii_Pirohov on 19.11.2014.
 */
public class AddUserSteps {

	AddUserTab addUserTab;
	UsersTab usersTab;

	public AddUserSteps(PageFactory factory) {
		this.addUserTab = factory.createPage(AddUserTab.class);
		this.usersTab = factory.createPage(UsersTab.class);
	}

	public void fillNameSurname(String fName, String lName) {
		usersTab.getAddUsersBtn().click();
		addUserTab.enterFirstName(fName);
		addUserTab.enterLastName(lName);
	}

	@Step("When I add new user {0},{1}")
	public void addNewUser(String fName, String lName) {
		fillNameSurname(fName, lName);
		addUserTab.clickSave();
	}

	@Step("When I set custom email {0}, {1}")
	public void addNewUserCustomEmail(String fName, String lName, String email) {
		fillNameSurname(fName, lName);
		addUserTab.renameEmail(email);
		addUserTab.clickSave();
	}

	@Step("When I create users with different roles {0}, {1}")
	public void addUserDifferentRoles(String fName, String lName, String role) {
		fillNameSurname(fName, lName);
		addUserTab.selectUsersRole(role);
		addUserTab.clickSave();
	}

	@Step("Verify empty FirstNameField")
	public String emptyNameFieldMessage() {
		return addUserTab.emptyNameMessage().getText();
	}

	@Step("Verify empty LastNameField")
	public String emptySurnameFieldMessage() {
		return addUserTab.emptySurnameMessage().getText();
	}

}
