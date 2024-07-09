package performance.upskilling.atf.configuration.properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesManager {
    // TODO Define what proprieties you are calling direct, and what from method here
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

    public static String getIndexURL(){
      return   properties.getProperty("index.url");
    }

    public static String getOverviewURL(){return   properties.getProperty("overview.url");}

    public static String getLoginURL(){ return properties.getProperty("login.url"); }

    public static String getRegisterURL() { return properties.getProperty("register.url"); }


}
