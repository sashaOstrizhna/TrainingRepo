package khppp.application.steps;

import khppp.application.components.AssignTasksTab;
import khppp.application.components.GroupJournalPage;
import khppp.application.components.GroupsTab;
import khppp.factory.PageFactory;

/**
 * Created by Anastasiia_Borodaiev on 12/4/2014.
 */
public class GroupJournalSteps {
    GroupJournalPage groupJournalPage;
    GroupsTab groupsTab;
    AssignTasksTab assignTasksTab;

    public GroupJournalSteps(PageFactory factory) {
        this.groupJournalPage = factory.createPage(GroupJournalPage.class);
        this.groupsTab = factory.createPage(GroupsTab.class);
        this.assignTasksTab = factory.createPage(AssignTasksTab.class);
    }


    public void deleteSubgroupByName(String subGroupName){
        groupJournalPage.deleteSubgroupByName(subGroupName);
    }

    public boolean isEmptyGroupJournalDisplayed() {
        return groupJournalPage.isEmptySignDisplayed("irenEmptySubgroup");
    }

    public boolean isGroupJournalDisplayed() {
        return groupJournalPage.isPageNameDisplayed();
    }

    public boolean isGroupDisplayed() {
        return groupJournalPage.isGroupNameDisplayed();
    }

    public boolean isGroupJournalDisplayedI() {
        return groupJournalPage.isCreatedSubgroupDisplayed("irenSubgroup");
    }

    public boolean isAddSubgroupDisplayed() {
        return groupJournalPage.isBtnAddSubgroupDisplayed();
    }

    public boolean isAssignDisplayed() {
        return groupJournalPage.isBtnAssignDisplayed();
    }

    public boolean isExportDisplayed() {
        return groupJournalPage.isBtnExportDisplayed();
    }

    public boolean isBackDisplayed() {
        return groupJournalPage.isBtnBackDisplayed();
    }

    public void goToAssignTaskPage() {
        groupJournalPage.clickAssignBtn();
    }
}
