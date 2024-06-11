package performance.upskilling.atf.configuration.properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {

    private Properties properties;
    private static final Logger logger = LogManager.getLogger(PropertiesManager.class);

    private PropertiesManager(){
        try(FileInputStream input = new FileInputStream("src/test/java/resources/properties/test.properties")){
            properties.load(input);

        }catch (IOException e){
            logger.error("Error loading properties file: " + e.getMessage());
        }
    }//end PropertiesManager

    public String getUsername() {
        return properties.getProperty("Username");
    }

    public String getPassword() {
        return properties.getProperty("Password");
    }

}
