package khppp.application.steps;

import khppp.application.components.PersonalJournalPage;
import khppp.factory.PageFactory;

import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Iryna_Perekhod on 11/28/2014.
 */
public class StatusSteps {

    PersonalJournalPage personalJournalPage;

    public StatusSteps(PageFactory factory) {
        this.personalJournalPage = factory.createPage(PersonalJournalPage.class);
    }

    public void clickTaskNameStep(){
        personalJournalPage.clickTaskName();
    }

    public void clickCloseBtnStep(){
        personalJournalPage.clickClosedBtn();
    }
    public void clickInProgressBtnStep(){
        personalJournalPage.clickInProgressBtn();
    }
    public void clickResolvedBtn() {personalJournalPage.clickResolvedBtn();}

    public boolean statusChanged(String statusState){
       return personalJournalPage.checkStatus().equals(statusState);
    }

}
