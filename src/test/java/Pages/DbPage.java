package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DbPage {
    public WebDriver driver;

    public DbPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //******Page Elements*****
    @FindBy(how = How.ID, using = "dbTypeDropdown")
    public WebElement dbTypeDropdown;

    @FindBy(how = How.ID, using = "sidServDropdown")
    public WebElement sidServDropdown;

    @FindBy(how = How.ID, using = "hostInput")
    public WebElement hostInput;

    @FindBy(how = How.ID, using = "portInput")
    public WebElement portInput;

    @FindBy(how = How.ID, using = "usernameInput")
    public WebElement usernameInput;

    @FindBy(how = How.ID, using = "dbNameInput")
    public WebElement dbNameInput;

    @FindBy(how = How.ID, using = "passInput")
    public WebElement passInput;

    @FindBy(how = How.ID, using = "sidServInput")
    public WebElement sidServInput;

    @FindBy(how = How.ID, using = "addDb")
    public WebElement btnAddDb;

    @FindBy(how = How.ID, using = "editDb")
    public WebElement btnEditDb;

    @FindBy(how = How.ID, using = "deleteDb")
    public WebElement btnDeleteDb;


    //******Actions*****
    public void openDbPage(String systemName) {
        driver.get("adress should be here" + systemName);
    }

    public void selectDb(String dbType) {
        Select DbDropdown = new Select(dbTypeDropdown);
        DbDropdown.selectByVisibleText(dbType);
    }

    public void selectSidOrServ(String sidServ) {
        Select ssDropdown = new Select(sidServDropdown);
        ssDropdown.selectByVisibleText(sidServ);
    }

    public void clickAddBd() {
        btnAddDb.click();
    }

    public void clickEditBd() {
        btnEditDb.click();
    }

    public void clickDeleteBd() {
        btnDeleteDb.click();
    }

    public boolean dbAddedSuccess() {
        //depends on implementaion
        return true;
    }

    public void deleteDbByHost(String host) {
        //depends on implementaion
    }

    public boolean dbIsDeleted(){
        //depends on implementaion
        return true;
    }
}
