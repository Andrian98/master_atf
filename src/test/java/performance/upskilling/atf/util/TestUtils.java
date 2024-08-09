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
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
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
                logger.error("Failed to add screenshot: {}", e.getMessage());
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
                        logger.error(e.getMessage());
                    }
                });
            }
        } catch (IOException e) {
            logger.error("Failed to move data in Evidence: {}", e.getMessage());
        }
    }

    public static void createEvidenceDirectory() {
        String timestamp = generateTimestamp();
        evidenceDir = Paths.get("target", "evidence", timestamp);
        try {
            Files.createDirectories(evidenceDir);
            logger.info("Evidence directory created");
        } catch (IOException e) {
            logger.error("Failed to create evidence directory: {}", e.getMessage());
        }
    }

    private static String generateTimestamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm");
        return LocalDateTime.now().format(formatter);
    }

    public static void cleanUpOldEvidence() {
        Path dir = Paths.get("target", "evidence");
        long thresholdMillis = Instant.now().minus(3, ChronoUnit.DAYS).toEpochMilli();

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path entry : stream) {
                if (Files.isDirectory(entry)) {
                    BasicFileAttributes attrs = Files.readAttributes(entry, BasicFileAttributes.class);
                    if (attrs.lastModifiedTime().toMillis() < thresholdMillis) {
                        deleteDirectoryRecursively(entry);
                    }
                }
            }
        } catch (IOException e) {
            logger.error("Failed to clean up old evidence directory: {}", e.getMessage());
        }
    }

    private static void deleteDirectoryRecursively(Path dir) throws IOException {
        // Recursively delete contents of subdirectories
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path entry : stream) {
                if (Files.isDirectory(entry)) {
                    deleteDirectoryRecursively(entry); // Recursive call for subdirectories
                } else if (Files.isRegularFile(entry)) {
                    Files.delete(entry); // Delete files
                    logger.info("Deleted file: {}", entry);
                }
            }
        }
        // After all contents are deleted, delete the directory itself
        Files.delete(dir);
        logger.info("Deleted directory: {}", dir);
    }

}
