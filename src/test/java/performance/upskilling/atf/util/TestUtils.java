package performance.upskilling.atf.util;

import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import performance.upskilling.atf.configuration.driverfactory.WebDriverManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TestUtils {
    private static final Logger logger = LogManager.getLogger();
    private static Path evidenceDir;

    public static String takeScreenShot() {
        TakesScreenshot takesScreenshot = (TakesScreenshot) WebDriverManager.getDriver();
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String timestamp = new SimpleDateFormat("HHmmssSSS_ddMMyyyy").format(new Date());
        String screenshotDir = evidenceDir + "/screenshots";
        String screenshotPath = screenshotDir + File.separator + "screenshot_" + timestamp + ".png";

        try {
            Files.createDirectories(Paths.get(screenshotDir));
            Files.copy(srcFile.toPath(), Paths.get(screenshotPath));
            logger.info("Screenshot saved at {}", screenshotPath);
            return screenshotPath;
        } catch (IOException e) {
            logger.error("Failed to save screenshot: {}", e.getMessage());
            return null;
        }
    }

    public static void addScreenshotsToReport(Scenario scenario) {
        String screenshotPath = takeScreenShot();
        if (screenshotPath != null) {
            try {
                Path path = Paths.get(screenshotPath);
                byte[] screenshot = Files.readAllBytes(path); // Read the screenshot file as bytes
                scenario.attach(screenshot, "image/png", "Screenshot"); // Attach the screenshot to the scenario
                logger.info("Screenshot attached ");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void addEvidence() {
        Path testReportsDir = Paths.get("target", "working-directory");
        try {

            if (Files.exists(testReportsDir) && Files.isDirectory(testReportsDir)) {
                Files.list(testReportsDir).forEach(source -> {
                    Path destination = evidenceDir.resolve(source.getFileName());
                    try {
                        Files.move(source, destination);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createEvidenceDirectory() {
        String timestamp = generateTimestamp();
        evidenceDir = Paths.get("target", "evidence", timestamp);
        try {
            Files.createDirectories(evidenceDir);
            logger.info("Evidence directory created");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String generateTimestamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm");
        return LocalDateTime.now().format(formatter);
    }

}
