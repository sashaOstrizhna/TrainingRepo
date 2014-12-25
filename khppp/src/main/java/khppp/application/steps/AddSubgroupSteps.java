package khppp.application.steps;

import khppp.application.components.*;
import khppp.factory.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Iryna_Perekhod on 12/10/2014.
 */
public class AddSubgroupSteps {

    NavBar navBar;
    AddSubgroupTab addSubgroupTab;
    GroupJournalPage groupJournalPage;
    GroupsTab groupsTab;

    public AddSubgroupSteps(PageFactory factory) {
        this.navBar = factory.createPage(NavBar.class);
        this.addSubgroupTab = factory.createPage(AddSubgroupTab.class);
        this.groupJournalPage = factory.createPage(GroupJournalPage.class);
        this.groupsTab = factory.createPage(GroupsTab.class);
    }

    @Step("When I add new subgroup {0},{1}")
    public void addNewEmptySubgroup(String subName, String groupName) {

        groupsTab.clickGroupByName(groupName);
        groupJournalPage.clickAddSubgroupBtn();
        addSubgroupTab.enterSubgroupName(subName);
        addSubgroupTab.clickSaveBtn();
    }

    public void addNewSubgroup(String subName, String mentorName, String menteeName, String groupName) {

        groupsTab.clickGroupByName(groupName);
        groupJournalPage.clickAddSubgroupBtn();
        addSubgroupTab.enterSubgroupName(subName);
        addSubgroupTab.selectMentor(mentorName);
        addSubgroupTab.chooseMentee(menteeName);
        addSubgroupTab.clickAddBtn();
        addSubgroupTab.clickSaveBtn();
    }


}
