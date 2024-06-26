package performance.upskilling.atf.configuration.properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesManager {

    private static final Properties properties = new Properties();
    private static final Logger logger = LogManager.getLogger(PropertiesManager.class);

    static {
        try (InputStream input = PropertiesManager.class.getClassLoader().getResourceAsStream("properties/test.properties")) {
            if (input != null) {
                properties.load(input);
            } else {
                logger.error("Error loading properties file: file not found");
            }
        } catch (IOException e) {
            logger.error("Error loading properties file: {}", e.getMessage());
        }
    }

    public static String getNewPassword() {
        return properties.getProperty("NewPassword");
    }

    public static String getUsername() {
        return properties.getProperty("Username");
    }

    public static String getPassword() {
        return properties.getProperty("Password");
    }

    public static String getAppURL() {
        return properties.getProperty("app.url");
    }

    public static String getAppDashboard() {
        return properties.getProperty("app.dashboard");
    }

    public static String getAppBuzzboard() {
        return properties.getProperty("app.buzzboard");
    }

    public static String getAppPasswordBoard() {
        return properties.getProperty("app.updatePassword");
    }

    public static String getAdminUser() {
        return properties.getProperty("AdminUser");
    }

    public static String getAdminPassword() {
        return properties.getProperty("AdminPassword");
    }

    public static String getAppAuth() {
        return properties.getProperty("app.auth");
    }

    public static String getAppLogin() {return  properties.getProperty("app.login");}

}
