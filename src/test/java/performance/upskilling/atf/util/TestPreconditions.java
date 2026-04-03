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
    private WebDriver driver;
    private WebDriverWait wait;
    private CoreInteractions coreInteractions = new CoreInteractions();
    private final AdminPageElements adminPageElements = new AdminPageElements();
    private RegistrationPageElements registrationPageElements = new RegistrationPageElements();
    private final Logger logger = LogManager.getLogger();

    public TestPreconditions() {
        this.driver = WebDriverManager.getDriver();
        wait = WebDriverWaiter.getWaiter(driver);
    }

    public void accessAdminURL() {
        coreInteractions.navigateTo(PropertiesManager.getAdminURL());
    }

    public void validateAdminSetUp() {
        accessAdminURL();
        coreInteractions.clickButton(adminPageElements.getCleanDataBase());
        adminPageElements.validateDatabaseCleanUp();
        coreInteractions.clickButton(adminPageElements.getDatabaseInitialize());
        if (adminPageElements.getJmsServiceStatus().getText().contains("Stopped")) {
            coreInteractions.clickButton(adminPageElements.getJmsServiceStatusButton());
        }
        coreInteractions.clickButton(adminPageElements.getDataAccessModeJDBC());
        adminPageElements.getSoapEndpoint().clear();
        adminPageElements.getRestEndpoint().clear();
        adminPageElements.getEndpoint().clear();
        adminPageElements.getInitBalance().clear();
        coreInteractions.selectOptionFromDropDown(adminPageElements.getLoanProviderOption(),"Web Service");
        coreInteractions.selectOptionFromDropDown(adminPageElements.getLoanProcessorOption(),"Available Funds");
        adminPageElements.getInitBalance().sendKeys("5150.50");
        adminPageElements.getMinBalance().clear();
        adminPageElements.getMinBalance().sendKeys("100.00");
        coreInteractions.clickButton(adminPageElements.getSubmitButton());
        logger.info("Preconditions successfully executed.");
    }

    public void registerNewUser() {
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
        coreInteractions.clickButton(registrationPageElements.getRegisterButton());
    }
}
