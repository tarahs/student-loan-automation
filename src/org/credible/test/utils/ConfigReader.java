package org.credible.test.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Configuration Reader
 */
public class ConfigReader {

    private  static String chromePath;
    private  static String browser;
    private  static String firefoxPath;
    private  static String email;
    private  static String password;


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
        Properties property = new Properties();
        try {
            property.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Cant't read config.properties file!");
            return;
        }
        browser = property.getProperty("BROWSER");
        chromePath = property.getProperty("CHROME_PATH");
        firefoxPath = property.getProperty("FIREFOX_PATH");
        email = property.getProperty("EMAIL");
        password = property.getProperty("PASSWORD");

    }

    public static String getChromePath() {
        return chromePath;
    }

    public static String getBrowser() {
        return browser;
    }

    public static String getFirefoxPath() {
        return firefoxPath;
    }

    public static String getEmail() {
        return email;
    }

    public static String getPassword() {
        return password;
    }
}