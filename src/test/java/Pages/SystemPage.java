package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SystemPage {

    public WebDriver driver;

    public SystemPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

//******Page Elements*****

    @FindBy(how = How.ID, using = "systemNameInput")
    public WebElement systemNameInput;

    @FindBy(how = How.ID, using = "systemDescrtiptionInput")
    public WebElement systemDescrtiptionInput;

    @FindBy(how = How.ID, using = "searchSystemInput")
    public WebElement searchSystemInput;

    @FindBy(how = How.ID, using = "addSystem")
    public WebElement btnAddSystem;

    @FindBy(how = How.ID, using = "editSystem")
    public WebElement btnEditSystem;

    @FindBy(how = How.ID, using = "deleteSystem")
    public WebElement btnDeleteSystem;

    @FindBy(how = How.ID, using = "btnsearchSystem")
    public WebElement btnsearchSystem;

    @FindBy(how = How.ID, using = "btnSaveSystem")
    public WebElement btnSaveSystem;


//******Actions*****

    public void openSystemPage() {
        driver.get("adress should be here");
    }

    public boolean searchResultIsEmpty(){
        //depends on implementaion
        return true;
    }

    public void clickAddSystem() {
        btnAddSystem.click();
    }

    public void clickEditSystem() {
        btnEditSystem.click();
    }

    public void clickDeleteSystem() {
        btnDeleteSystem.click();
    }

    public void clickSearchSystem() {
        btnsearchSystem.click();
    }

    public void clickSaveSystem() {
        btnSaveSystem.click();
    }

    public boolean systemAddedSuccess(){
        //depends on implementaion
        return true;
    }

}
