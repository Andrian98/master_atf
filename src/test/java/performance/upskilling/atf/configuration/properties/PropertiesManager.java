package performance.upskilling.atf.configuration.properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesManager {
    private static final Properties properties = new Properties();
    private static final Logger logger = LogManager.getLogger();

    static {
        try (InputStream input = PropertiesManager.class.getClassLoader().getResourceAsStream("properties/test.properties")) {
            properties.load(input);
        } catch (IOException e) {
            logger.error("Error loading properties file: {}", e.getMessage());
        }
    }

    public static String getIndexURL() {
        return properties.getProperty("index.api");
    }

    public static String getLoginURL() {
        return properties.getProperty("login.api");
    }

    public static String getRegisterURL() {
        return properties.getProperty("register.url");
    }

    public static String getBrowser() {
        return properties.getProperty("browser");
    }

    public static Integer getDefaultTimeOut() {
        return Integer.parseInt(properties.getProperty("defaultTimeOut"));
    }

    public static String getUserAccountsURL() {
        return properties.getProperty("userAccounts.api");
    }

    public static String getCreateAccountURL() {
        return properties.getProperty("createAccount.api");
    }

    public static String getRequestLoanURL() {
        return properties.getProperty("requestLoan.url");
    }

    public static String getTransferUrl() {
        return properties.getProperty("transfer.url");
    }

    public static String getUsername() {
        return properties.getProperty("username");
    }

    public static String getPassword() {
        return properties.getProperty("password");
    }

    public static String getAdminURL() {
        return properties.getProperty("admin.url");
    }

    public static String getOpenAccountURL() {
        return properties.getProperty("openAccount.url");
    }

    public static Integer getEvidenceRetentionPeriod() {
        return Integer.parseInt(properties.getProperty("evidenceRetentionPeriod"));
    }

    public static String getEvidencePath(){
        return properties.getProperty("evidencePath");
    }

    public static String getAccountOverview(){
        return properties.getProperty("accountOverview.url");
    }


}
