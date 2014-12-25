package khppp.application.steps;

import khppp.application.components.AddGroupTab;
import khppp.application.components.GroupJournalPage;
import khppp.application.components.GroupsTab;
import khppp.application.entitites.Group;
import khppp.factory.PageFactory;
import sun.rmi.runtime.Log;

import java.util.List;

/**
 * Created by Oleksandra_Ostrizhna on 11/28/2014.
 */
public class GroupsTabSteps {

    GroupsTab groupsTab;
    AddGroupTab addGroupTab;

    public GroupsTabSteps(PageFactory factory) {
        this.groupsTab = factory.createPage(GroupsTab.class);
        this.addGroupTab = factory.createPage(AddGroupTab.class);
    }

    public boolean groupTabDisplayed() {
        return groupsTab.groupTabNameDisplayed();
    }

    public boolean btnAddGroupDisplayed() {
        return groupsTab.btnAddGroupDisplayed();
    }

    public boolean btnExportDisplayed() {
        return groupsTab.btnExportDisplayed();
    }

    public boolean emptyGroupCreated(String groupname) {
        return groupsTab.createGroupDisplayed(groupname);
    }

    public boolean groupWithMenteeCreated(String groupName, int numOfMentees) {
        return groupsTab.groupWithMenteesDisplayed(groupName, numOfMentees);
    }

    public boolean groupsTabTableHeadDisplayed(int numOfLabels) {
        return groupsTab.getGroupsTableHead(numOfLabels);
    }

    public void goToGroupJournalPAge() {
        groupsTab.clickFirstGroup();
    }

    public void goToNotEmptyGroup(){groupsTab.clickFirstNotEmptyGroup();}
    public AddGroupTab goToAddGroupTab() {
        groupsTab.getAddGroupBtn().click();
        return addGroupTab;
    }

}
