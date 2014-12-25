package khppp.application.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by Iryna_Perekhod on 12/18/2014.
 */
public class GroupTasksPage extends Component{

    public GroupTasksPage(WebDriver driver) {
        super(driver);
    }

    public WebElement sortByTaskNameBtn() {
        return waitFor(xpath(".//*[@id='table_head']/tr/th[1]/span"));
    }
    public WebElement sortByStartDateBtn() {
        return waitFor(xpath(".//*[@id='table_head']/tr/th[2]"));
    }
    public WebElement sortByDeadlineBtn() {
        return waitFor(xpath(".//*[@id='table_head']/tr/th[3]"));
    }

    public WebElement filterBtn(){ return waitFor(xpath("//input[@id='filter-btn']"));}
    public WebElement taskNameInput() {return waitFor(xpath("//input[@id='input-task-name']"));}
    public WebElement setFilterBtn(){return waitFor(xpath("//input[@value='Set Filter']"));}
    public WebElement removeBtn(){ return waitFor(xpath("//table[@id='table_group_journal']/tbody/tr[1]/td[6]/button"));}

    public List<String> getAllTasks() {
        sortByTaskNameBtn().click();
        List<WebElement> allTaskNames = findAll(xpath("//table[@id='table_group_journal']/tbody/tr/td[1]"));
        List<String> allTaskNamesString = new ArrayList<>();
            for (int i=1; i<allTaskNames.size()-1; i++){
             allTaskNamesString.add(allTaskNames.get(i).getText());}
        System.out.println(allTaskNamesString);
        return allTaskNamesString;
    }

    public boolean checkSortByTaskName(){
        System.out.println("---- TaskName sort ----");
        System.out.println(getAllTasks());
        Collections.sort(getAllTasks());
        System.out.println("---- TaskName sort -- Mine ----");
        System.out.println(getAllTasks());

        List<String> allTaskNamesStringSorted = getAllTasks();
        boolean flag = true;
        for (String i : getAllTasks()) {
            if (!i.equals(allTaskNamesStringSorted.get(0))) {
                flag = false;
                System.out.println(i + "!=" + allTaskNamesStringSorted.get(0));
                break;
            }
            allTaskNamesStringSorted.remove(0);
        }
        if (flag == false)
            System.out.println("сортировка по названию неверна!");
        else
            System.out.println("сортировка по названию верна!");
        return flag;
    }

    public List<String> filterByTaskName(String taskNameInput){
        filterBtn().click();
        taskNameInput().sendKeys(taskNameInput);
        setFilterBtn().click();
        List<WebElement> tasksFound = waitForAll(xpath("//table[@id='table_group_journal']/tbody/tr/td[1])"));
        List<String> tasksFoundString = new ArrayList<>();
        for (WebElement el: tasksFound)
            tasksFoundString.add(el.getText().toLowerCase());
        return tasksFoundString;
    }

    public boolean checkFilter(String taskNameInput){
        boolean flag = false;
        for (String str:filterByTaskName(taskNameInput)){
            if (str.contains(taskNameInput.toLowerCase()))
                flag = true;
        }
        return flag;
    }

    public boolean checkRemoveBtn(){
        boolean flag = true;
        if (removeBtn().getAttribute("disabled")==""){
            flag = false;
        }
        return flag;
    }


}
