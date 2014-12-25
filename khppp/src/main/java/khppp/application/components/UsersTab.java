package khppp.application.components;

import khppp.application.entitites.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.By.id;

/**
 * Created by Serhii_Pirohov on 18.11.2014.
 */
public class UsersTab extends Component {

	public UsersTab(WebDriver driver) {
		super(driver);
	}

	//	.//*[@id='group_journal']/div/div/div[2]/button[1]
	public WebElement getExportBtn() {
		return waitFor(id("create_csv_button"));
	}

	public WebElement getAddUsersBtn() {
		return waitFor(xpath("//*[@id='wrap']//a[contains(.,'Add Users')]"));
	}

	public List<User> getAllUsers() {
		int numberOfRows = waitForAll(xpath("//*[@id='table_body']/tr")).size();
		System.out.println("ROWS " + numberOfRows);
		List<User> users = new ArrayList<>();
		for (int i = 1; i < numberOfRows - 1; i++) {
			List<WebElement> columns = findAll(xpath(
					"//*[@id='table_group_journal']//tr[%s]//td", i));
			User user = new User();
			user.setFirstName(columns.get(0).getText());
			user.setLastName(columns.get(2).getText());
			System.out.println("User " + user);
			users.add(user);
		}
		return users;
	}

	public boolean isCreateUserDisplayed(String userName) {
		return displayed(xpath("//td[contains(.,'%s')][1]", userName));
	}

    public WebElement getFirstUser(String userName){
       WebElement firstUser = waitFor(xpath("//td[contains(.,'%s')][1]", userName));
    return firstUser;
    }
}
