package data;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Settings {

    private static WebDriver driver;
    private DataStorage dataStorage;
    private static final String RESOURCES_PATH = "src/Properties/${NAME}.properties";
    private boolean acceptNextAlert = true;


    public Settings() {
        this.setDataStorage(DataStorage.getInstance());
        try {
            initProperties("Settings");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        Settings.driver = driver;
    }

    public String getBaseUrl() {
        return DataStorage.getProperty("Settings").getProperty("url.base");
    }

    public String getChromeDriverPath() {
        return DataStorage.getProperty("Settings").getProperty("path.chromedriver");
    }

    public String getIEDriverPath() {
        return DataStorage.getProperty("Settings").getProperty("path.iedriver");
    }

    /*public static void setBaseUrl(String baseUrl) {
        Settings.baseUrl = baseUrl;
    } */


    public void initProperties() throws FileNotFoundException, IOException {
        initProperties(getClass().getSimpleName());
    }

    public void initProperties(String propertiesFileName) {
        String workingDir = System.getProperty("user.dir");
        if (!DataStorage.exists(propertiesFileName)) {
            Properties properties = new Properties();
            File propertiesFile = new File(workingDir + "\\src\\Properties\\" + propertiesFileName + ".properties");

            try {
                properties.load(new FileReader(propertiesFile));
                DataStorage.setProperty(propertiesFileName, properties);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public final String getProperty(String key) {
        return DataStorage.getProperty(getClass().getSimpleName()).getProperty(key);
    }

    public void setDataStorage(DataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

    public DataStorage getDataStorage() {
        return dataStorage;
    }

    public String getResourcesPath(String name) {
        return RESOURCES_PATH.replaceAll("\\$\\{NAME\\}", name);
    }

    public void goHome() {
        driver.get(getBaseUrl());
    }

    public void driverClose() {
        driver.close();
    }

    public static void wait(int milliSeconds) throws InterruptedException {
        Thread.sleep(milliSeconds);
    }

    public void alertAcept() {
        driver.switchTo().alert().accept();

    }

    public boolean isElementPresent(By by) {
        try {
            getDriver().findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String closeAlertAndGetItsText() {

        Alert alert = getDriver().switchTo().alert();
        if (acceptNextAlert) {
            alert.accept();
        } else {
            alert.dismiss();
        }
        return alert.getText();

    }
}

//    public void alertAceptVerify(){
//        driver.verifyAlert;
//
//    }

