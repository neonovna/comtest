package Steps;

import Base.BaseUtil;
import Pages.DbPage;
import Pages.SystemPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class MyStepdefs {
    private BaseUtil base;
    private SystemPage systempage;
    private DbPage dbpage;

    public MyStepdefs(BaseUtil base) {
        this.base = base;
        this.systempage = new SystemPage(base.Driver);
        this.dbpage = new DbPage(base.Driver);
    }

    @Given("^I am on System Page$")
    public void iAmOnSystemPage() {
        systempage.openSystemPage();
        assertTrue(base.Driver.getTitle().contains("Systems"));
    }

    @When("^Search for System$")
    public void searchForSystem(DataTable systemName) {
        List<List<String>> data = systemName.raw();
        systempage.searchSystemInput.sendKeys(data.get(0).get(0));
    }

    @And("^Search result is empty$")
    public void searchResultIsEmpty() {
        if (!systempage.searchResultIsEmpty()) {
            throw new RuntimeException("System is exist");
        }
    }

    @And("^Click on add System button$")
    public void clickOnAddSystemButton() {
        systempage.clickAddSystem();
    }

    @And("^Enter System name$")
    public void enterSystemName(DataTable systemName) {
        List<List<String>> data = systemName.raw();
        systempage.systemNameInput.sendKeys(data.get(0).get(0));
    }

    @And("^Enter System description$")
    public void enterSystemDescription(DataTable systemDesc) {
        List<List<String>> data = systemDesc.raw();
        systempage.systemDescrtiptionInput.sendKeys(data.get(0).get(0));
    }

    @And("^Save System$")
    public void saveSystem() {
        systempage.clickSaveSystem();
    }

    @Then("^System is added$")
    public void systemIsAdded() {
        assertTrue(systempage.systemAddedSuccess());
    }

    @Given("^I am on System Details page$")
    public void iAmOnSystemDetailsPage(DataTable systemName) {
        List<List<String>> data = systemName.raw();
        dbpage.openDbPage(data.get(0).get(0));
    }

    @When("^I select (.*)$")
    public void iSelectDBtype(String dbtype) {
        dbpage.selectDb(dbtype);
    }

    @And("^Enter values$")
    public void enterValues(DataTable tableValues) {
        List<List<String>> data = tableValues.raw();
        dbpage.hostInput.sendKeys(data.get(1).get(1));
        dbpage.portInput.sendKeys(data.get(2).get(1));
        dbpage.dbNameInput.sendKeys(data.get(3).get(1));
        dbpage.usernameInput.sendKeys(data.get(4).get(1));
        dbpage.passInput.sendKeys(data.get(5).get(1));
    }

    @And("^save DB$")
    public void saveDB() {
        dbpage.clickAddBd();
    }

    @Then("^DB is added$")
    public void dbIsAdded() {
        assertTrue(dbpage.dbAddedSuccess());
    }

    @And("^select ([^\"]*) with ([^\"]*)$")
    public void selectNameWithValue(String name, String value) {
        dbpage.selectSidOrServ(name);
        dbpage.sidServInput.sendKeys(value);
    }

    @And("^Search result is not empty$")
    public void searchResultIsNotEmpty() {
        if (systempage.searchResultIsEmpty()) {
            throw new RuntimeException("System do not exist");
        }
    }

    @And("^Click on edit System button$")
    public void clickOnEditSystemButton() {
        systempage.btnEditSystem.click();
    }

    @And("^Delete DB by host$")
    public void deleteDBByHost(DataTable dbhost) {
        List<List<String>> data = dbhost.raw();
        dbpage.deleteDbByHost(data.get(0).get(0));
    }

    @Then("^DB is deleted$")
    public void dbIsDeleted() {
        assertTrue(dbpage.dbIsDeleted());
    }

    @Then("^DB is updated$")
    public void dbIsUpdated() throws Throwable {
        //depends on implementaion
    }
}
