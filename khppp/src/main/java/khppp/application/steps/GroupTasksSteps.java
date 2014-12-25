package khppp.application.steps;

import khppp.application.components.GroupJournalPage;
import khppp.application.components.GroupTasksPage;
import khppp.application.components.GroupsTab;
import khppp.factory.PageFactory;

/**
 * Created by Iryna_Perekhod on 12/18/2014.
 */
public class GroupTasksSteps {

    GroupTasksPage groupTasksPage;
    GroupsTab groupsTab;
    GroupJournalPage groupJournalPage;

    public GroupTasksSteps(PageFactory factory) {
        this.groupTasksPage = factory.createPage(GroupTasksPage.class);
        this.groupsTab = factory.createPage(GroupsTab.class);
        this.groupJournalPage = factory.createPage(GroupJournalPage.class);
    }

    public GroupTasksPage goToGroupTasksPage() {
        groupsTab.clickFirstNotEmptyGroup();
        groupJournalPage.clickGroupTasksTab();
        return groupTasksPage;
    }

    public boolean isSortedByTaskName() {
        return groupTasksPage.checkSortByTaskName();
    }

    public boolean isFilteredByTaskName(String str){
        return groupTasksPage.checkFilter(str);
    }
}
