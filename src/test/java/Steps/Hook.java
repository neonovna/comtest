package Steps;

import Base.BaseUtil;
import Pages.SystemPage;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hook extends BaseUtil {

    private BaseUtil base;
    public SystemPage systempage;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void beforeScenario() {
        System.out.println("Opening a browser");
        base.Driver = new ChromeDriver();
        base.Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        base.Driver.manage().window().maximize();
        this.systempage = new SystemPage(base.Driver);
        systempage.openSystemPage();
    }

    @After
    public void afterScenario() {
        System.out.println("Closing a browser");
        base.Driver.quit();
    }
}
