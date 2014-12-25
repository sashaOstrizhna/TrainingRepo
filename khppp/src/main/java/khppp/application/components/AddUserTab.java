package khppp.application.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Serhii_Pirohov on 19.11.2014.
 */
public class AddUserTab extends Component {

	public AddUserTab(WebDriver driver) {
		super(driver);
	}

	public void enterFirstName(String firstName) {
		WebElement fName = waitFor(xpath("//*[@id='registration_table']//tr[1]/td[1]/input"));
		typeInto(fName, firstName);
	}

	public void enterLastName(String lastName) {
		WebElement lName = waitFor(xpath("//*[@id='registration_table']//tr[1]/td[2]/input"));
		typeInto(lName, lastName);
	}

	public void renameEmail(String customEmail) {
		WebElement defaultEmail = waitFor(xpath("//*[@id='registration_table']//tr[1]/td[3]/input"));
		defaultEmail.clear();
		typeInto(defaultEmail, customEmail);
	}

	public void selectUsersRole(String role) {
		Select select = new Select(find(By.xpath("//select[@name='role']")));
		select.selectByVisibleText(role);
	}


	public void clickSave() {
		waitFor(xpath("//*[@id='registration_form']/div/form/button[1]"))
				.click();
	}

	public WebElement emptyNameMessage() {
		return waitFor(xpath(".//*[@id='rowId0']/td[1]/span"));
	}

	public WebElement emptySurnameMessage() {
		return waitFor(xpath(".//*[@id='rowId0']/td[2]/span"));
	}

}
