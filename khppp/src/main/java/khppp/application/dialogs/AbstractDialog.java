package khppp.application.dialogs;

import khppp.application.components.Component;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.Set;

/**
 * Created by Serhii_Pirohov on 07.11.2014.
 */
public abstract class AbstractDialog extends Component {

	public AbstractDialog(WebDriver driver) {
		super(driver);
	}

	private boolean windowOpened;

	public abstract void switchToDialog();

	public void switchToDialog(String modalUrl) {
		waitForWindow(modalUrl);
		Set<String> handles = getDriver().getWindowHandles();
		if (handles.size() < 2) {
			for (String handle : handles) {
				if (!handle.equals(Component.getMainWindowHandler())) {
					String url = getDriver().switchTo().window(handle)
							.getCurrentUrl();
					if (url.contains(modalUrl)) {
						break;
					}
				}
			}
		}
	}

	private void waitForWindow(String name) {
		if (!windowOpened) {
			getWait().until(windowOpened(name));
			windowOpened = true;
		}
	}

	private ExpectedCondition<Boolean> windowOpened(final String winUrl) {
		final String[] url = new String[1];
		final boolean[] windowPresent = {false};
		return new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					Set<String> windowHandles = getDriver().getWindowHandles();
					for (String windowHandle : windowHandles) {
						url[0] = getDriver().switchTo().window(windowHandle)
								.getCurrentUrl();
						windowPresent[0] = url[0].contains(winUrl);
						if (windowPresent[0]) {
							break;
						}
					}
					return windowPresent[0];
				} catch (NoSuchWindowException e) {
					return false;
				} catch (StaleElementReferenceException e) {
					return false;
				}
			}
		};
	}

	public void switchToMainWindow() {
		getDriver().switchTo().window(getMainWindowHandler());
	}

}
