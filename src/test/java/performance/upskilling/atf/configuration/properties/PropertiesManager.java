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

    public static String getIndexURL(){
      return properties.getProperty("index.url");
    }

    public static String getLoginURL(){ return properties.getProperty("login.url"); }

    public static String getRegisterURL() { return properties.getProperty("register.url"); }

    public static String getBrowser(){ return properties.getProperty("browser"); }

    public static Integer getDefaultTimeOut(){ return Integer.parseInt(properties.getProperty("defaultTimeOut")); }

    public static String getUserAccountsURL(){ return properties.getProperty("userAccounts.url"); }

    public static String getCreateAccountURL(){ return properties.getProperty("createAccount.url"); }


}
