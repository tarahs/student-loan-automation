package org.credible.test.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Configuration Reader
 */
public class ConfigReader {

    private static String chromePath;
    private static String browser;
    private static String firefoxPath;

    /**
     * Class constructor loads settings from the file and saves to fields
     */
    public ConfigReader() {
        FileInputStream fis;
        try {
            fis = new FileInputStream("config/config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Cant't read config.properties file!");
            return;
        }
        Properties p = new Properties();
        try {
            p.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Cant't read config.properties file!");
            return;
        }
        browser = p.getProperty("BROWSER");
        chromePath = p.getProperty("CHROME_PATH");
        firefoxPath = p.getProperty("FIREFOX_PATH");

    }

    public  String getChromePath() {
        return chromePath;
    }

    public  String getBrowser() {
        return browser;
    }

    public static String getFirefoxPath() {
        return firefoxPath;
    }
}