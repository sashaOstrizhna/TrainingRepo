package khppp.application.entitites;

import org.openqa.selenium.WebElement;

public class Subgroup {

    private String subName;
    private String subMentor;
    private WebElement editBtn;

    public WebElement getRemoveBtn() {
        return removeBtn;
    }

    public void setRemoveBtn(WebElement removeBtn) {
        this.removeBtn = removeBtn;
    }

    public WebElement getEditBtn() {
        return editBtn;
    }

    public void setEditBtn(WebElement editBtn) {
        this.editBtn = editBtn;
    }

    public String getSubMentor() {
        return subMentor;
    }

    public void setSubMentor(String subMentor) {
        this.subMentor = subMentor;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    private WebElement removeBtn;


}

