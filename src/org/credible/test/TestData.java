package org.credible.test;


import org.credible.test.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.util.concurrent.TimeUnit;

public enum TestData {

    INSTANCE;
    private static final ConfigReader configReader = new ConfigReader();
    private static final String BROWSER = configReader.getBrowser();
    private static final String CHROME_PATH = configReader.getChromePath();
    private static final String FIREFOX_PATH = configReader.getFirefoxPath();
    private static WebDriver driver;
    public static final int WAIT_TIME = 10;

    /**
     * ------        Home Page       --------------
     */
    public static final String BASE_URL = "https://www.credible.com";
    public static final String HOME_PAGE = "/?vt_disabled=true";
    public static final String HOME_PAGE_TITTLE = "Credible | Find the Best Loans | Easily Compare & Save";


    /**
     * ------STUDENT -  EDUCATION SECTION  --------------
     */
    public static final String EDUCATION_SCHOOL_NAME = "Davis College";
    public static final String EDUCATION_GRAD_DATE = "12/2022";
    public static final String LOAN_AMOUNT = "$40000";

    /**
     * ------STUDENT - FINANCIAL SECTION ---------------
     */
    public static final String EMPLOYMENT_INCOME = "$50000";
    public static final String MONTHLY_HOUSING_PAYMENT = "$3000";
    public static final String INDIVIDUAL_INCOME = "$3000";

    /**
     * -------STUDENT - PROFILE SECTION ------------
     */
    public static final String FIRST_NAME = "Great";
    public static final String LAST_NAME = "CredibleProd";
    public static final String DOB = "10/05/1978";
    public static final String PHONE = "(415) 343-5465";
    public static final String ADDRESS = "842 Camden Common, Livermore, CA, USA";
    public static final String EMAIL = "tarahssunday1845@credible.com";
    public static final String STUDENT_PD= "Passw0rd";




    /**
     * Method to get the driver. WebDriver type is determined in
     * config.properties.
     * @return driver
     */
    public static synchronized WebDriver getDriver() {
        if (null == driver) {
            if (BROWSER.equals("FIREFOX")) {
                if (!FIREFOX_PATH.equals("")) {
                    try {
                        File pathToProfile = new File(FIREFOX_PATH);
                        FirefoxProfile profile = new FirefoxProfile(
                                pathToProfile);
                        driver = new FirefoxDriver(profile);
                    } catch (Exception e) {
                        e.printStackTrace();
                        driver = new FirefoxDriver();
                    }
                } else {
                    driver = new FirefoxDriver();
                }

            } else if (BROWSER.equals("CHROME")) {
                System.setProperty("webdriver.chrome.driver", CHROME_PATH);
                driver = new ChromeDriver();
                driver.manage().window().maximize();

            } else {
                driver = new FirefoxDriver();

            }
            driver.manage().timeouts()
                    .implicitlyWait(WAIT_TIME, TimeUnit.SECONDS);

        }

        return driver;
    }
}
