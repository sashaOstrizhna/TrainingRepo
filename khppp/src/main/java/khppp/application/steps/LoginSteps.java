package khppp.application.steps;

import khppp.application.components.LoginPage;
import khppp.factory.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Sergey on 04.11.2014.
 */

public class LoginSteps {

	LoginPage login;

	public LoginSteps(PageFactory pages) {
		login = pages.createPage(LoginPage.class);

	}

	@Step("When I login as {0} and {1}")
	public void login(String name, String password) {
		login.enterLogin(name);
		login.enterPassword(password);
		login.clickLoginBtn();
	}

	@Step("Then verify error message is displayed")
	public String errorMessage() {
		return login.getErrorMessage().getText();
	}

	@Step("Verify Incorrect Login or Password message")
	public String incorrectLoginPassword() {
		return login.getIncorrectLoginPassMessage().getText();
	}

}
