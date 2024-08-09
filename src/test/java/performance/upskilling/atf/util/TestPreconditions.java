package performance.upskilling.atf.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import performance.upskilling.atf.configuration.driverfactory.WebDriverManager;
import performance.upskilling.atf.configuration.driverfactory.WebDriverWaiter;
import performance.upskilling.atf.configuration.properties.PropertiesManager;
import performance.upskilling.atf.ui.pageobjects.AdminPageElements;
import performance.upskilling.atf.ui.pageobjects.RegistrationPageElements;

public class TestPreconditions {
    public WebDriver driver;
    public static WebDriverWait wait;
    public static TestCustomActions testCustomActions = new TestCustomActions();
    private static final AdminPageElements adminPageElements = new AdminPageElements();
    public RegistrationPageElements registrationPageElements = new RegistrationPageElements();
    private static final Logger logger = LogManager.getLogger();

    public TestPreconditions() {
        this.driver = WebDriverManager.getDriver();
        wait = WebDriverWaiter.getWaiter(driver);
    }

    public void accessAdminURL(){
        testCustomActions.navigateTo(PropertiesManager.getAdminURL());
    }

    public void validateAdminSetUp(){
        accessAdminURL();
        testCustomActions.clickButton(adminPageElements.getCleanDataBase());
        testCustomActions.clickButton(adminPageElements.getDatabaseInitialize());
        if(adminPageElements.getJmsServiceStatus().getText().contains("Stopped")){
            testCustomActions.clickButton(adminPageElements.getJmsServiceStatusButton());
        }
        testCustomActions.clickButton(adminPageElements.getDataAccessModeJDBC());
        adminPageElements.getSoapEndpoint().clear();
        adminPageElements.getRestEndpoint().clear();
        adminPageElements.getEndpoint().clear();
        adminPageElements.getInitBalance().clear();
        adminPageElements.getInitBalance().sendKeys("5150.50");
        adminPageElements.getMinBalance().clear();
        adminPageElements.getMinBalance().sendKeys("100.00");
        testCustomActions.clickButton(adminPageElements.getSubmitButton());
        logger.info("Preconditions executed.");
    }
    //TODO method is a action, rename this
    public void userIsRegistered(){
        registrationPageElements.getElement("First Name").sendKeys("perf");
        registrationPageElements.getElement("Last Name").sendKeys("user");
        registrationPageElements.getElement("Address").sendKeys("town");
        registrationPageElements.getElement("City").sendKeys("town");
        registrationPageElements.getElement("State").sendKeys("CA");
        registrationPageElements.getElement("Zip Code").sendKeys("2222");
        registrationPageElements.getElement("SSN").sendKeys("2222");
        registrationPageElements.getElement("Username").sendKeys("perf-user");
        registrationPageElements.getElement("Password").sendKeys("perf-user123");
        registrationPageElements.getElement("Confirm").sendKeys("perf-user123");
        testCustomActions.clickButton(registrationPageElements.getRegisterButton());
    }
}
