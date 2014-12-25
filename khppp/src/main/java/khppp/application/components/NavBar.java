package khppp.application.components;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.By.*;

/**
 * Created by Serhii_Pirohov on 18.11.2014.
 */
public class NavBar extends Component {

	public NavBar(WebDriver driver) {
		super(driver);
	}

	public WebElement getUserName() {
		return waitFor(cssSelector(".user_status"));
	}

	public WebElement getTab(String name) {
		return waitFor(xpath("//a[contains(.,'%s')]", name));
	}

    public WebElement getLogoutBtn() {
        return waitFor(xpath("//ul[@class='nav navbar-nav navbar-right']/li/a"));
    }

}
