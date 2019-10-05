package org.credible.test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

/* USE CASE
1. Select I am the borrower
2. In the next page, Education step, select 'No' for the first 2 radio options
3. Continue providing some test data (you can use any address, amount etc.,) for Education, Finance, Profile pages
4. You can use the borrower name as follows - first name as Great, last name as CredibleProd
5. No need to submit the form when it comes to the last step, where you see "Agree and Find my rates"
6. User email id should be in the format:  <YourFirstName>+<MonthDay>+<timestamp>@credible.com
7. Password is Passw0rd
*/

public class StudentLoan {

    private  WebDriver driver;
    private WebDriverWait wait;



    @BeforeClass
    public void setup() {
        driver = TestData.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 5);
        driver.get(TestData.BASE_URL+TestData.HOME_PAGE);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }


    /**
     * Assert Successful application launch
     */
    @Test(priority = 1)
    public void application_launch_verification() {
        String title = TestData.HOME_PAGE_TITTLE;
        Assert.assertEquals(title, driver.getTitle());
    }

    /**
     * Click on student loan tile on Landing Page
     */
    @Test(priority = 2)
    public void click_on_student_loan_tile(){

        WebElement student_loan_button = driver.findElement(
                By.cssSelector("#root > div > div > div._2ZPgUqDs.ExHqkrHA > div:nth-child(1) > div > div > div.fixed-section-relative-wrapper._189b8407 > div:nth-child(1) > div._2TG9Sozx > div:nth-child(1) > div > div > div._3Ty4AGP- > button"));
        student_loan_button.click();

    }

    /**
     * Select I am the student
     */
    @Test(priority = 3)
    public void select_iam_the_student(){

        driver.findElement(
                By.cssSelector("#root > div > div > div._2ZPgUqDs.ExHqkrHA > div:nth-child(1) > div > div > div.fixed-section-relative-wrapper._189b8407 > div:nth-child(1) > div._2TG9Sozx > div:nth-child(1) > div > div > div._2Ls7a0_K._1bLzy8wE > div._1YIZTP9I > div:nth-child(2) > button")).click();

    }



    /**
     * Fill all the fields in the education section
     * @throws InterruptedException
     */
    @Test(priority = 4)
    public void fill_data_to_education_section() throws InterruptedException {

        //Checked rates before radio
        driver.findElement(By.cssSelector("#c148_checked_rates > div:nth-child(3) > label")).click();

        //Borrower has cosigner radio
        driver.findElement(By.cssSelector("#c92_borrower_has_cosigner > div:nth-child(3) > label")).click();

        //SChool name
        driver.findElement(By.cssSelector("#c92_education_name")).sendKeys(TestData.EDUCATION_SCHOOL_NAME);
        selectOptionWithIndex(0, "#form-step > div > div:nth-child(1) > div > fieldset > div:nth-child(3) > div > div > span:nth-child(2) > span > div > div");

        //Degree Type
        driver.findElement(By.cssSelector("#s2id_c92_education_degree_type")).click();
        driver.findElement(By.cssSelector("#select2-results-1 > li:nth-child(1) > ul > li:nth-child(1)")).click();

        //Year of Study
        driver.findElement(By.cssSelector("#s2id_c92_education_current_year > a")).click();
        driver.findElement(By.cssSelector("#select2-results-3 > li:nth-child(1)")).click();

        //Grad Completion date
        driver.findElement(By.cssSelector("#c92_education_completion_date")).sendKeys(TestData.EDUCATION_GRAD_DATE);

        //Period of loan
        driver.findElement(By.cssSelector("#s2id_c92_education_academic_period_loan")).click();
        driver.findElement(By.cssSelector("#select2-results-4 > li:nth-child(1)")).click();

        //Loan Amount
        driver.findElement(By.cssSelector("#c92_education_requested_loan_amount")).sendKeys(TestData.LOAN_AMOUNT);

        //Continue Button
        driver.findElement(By.cssSelector("#form-step > div > div:nth-child(1) > div > fieldset > div.form-navigation > div")).click();


    }

    /**
     * Fill all the fields in the financial section
     */
    @Test(priority = 5)
    public void fill_data_to_financial_scetion(){

        //Employment Income
        driver.findElement(By.cssSelector("#c92_borrower_income_yearly")).sendKeys(TestData.EMPLOYMENT_INCOME);

        //Individual Income
        driver.findElement(By.cssSelector("#c92_borrower_additional_income")).sendKeys(TestData.INDIVIDUAL_INCOME);

        //Monthly housing payment
        driver.findElement(By.cssSelector("#c92_borrower_housing_payment")).sendKeys(TestData.MONTHLY_HOUSING_PAYMENT);

        //Citizenship status
        driver.findElement(By.cssSelector("#s2id_c92_borrower_citizenship_status")).click();
        driver.findElement(By.cssSelector("#select2-results-7 > li.select2-results-dept-0.select2-result.select2-result-selectable.select2-highlighted")).click();

        //Continue Button
        driver.findElement(By.cssSelector("#form-step > div > div:nth-child(2) > div > div > div.next-step > button")).click();

    }

    /**
     * Fill all the fields in the profile section
     */
    @Test(priority = 6)
    public void fill_data_to_profile_section(){

        //First Name
        driver.findElement(By.cssSelector("#c92_borrower_first_name")).sendKeys(TestData.FIRST_NAME);

        //Last Name
        driver.findElement(By.cssSelector("#c92_borrower_last_name")).sendKeys(TestData.LAST_NAME);

        //DOB
        driver.findElement(By.cssSelector("#c92_borrower_dob")).sendKeys(TestData.DOB);

        //Phone
        driver.findElement(By.cssSelector("#c92_borrower_phone")).sendKeys(TestData.PHONE);

        //Address
        driver.findElement(By.cssSelector("#c92_current_address_full_address")).sendKeys(TestData.ADDRESS);
        selectOptionWithIndex(0, "body > div.pac-container.pac-logo.hdpi");

        //Email
        driver.findElement(By.cssSelector("#c240_email")).sendKeys(TestData.EMAIL);

        //Password
        driver.findElement(By.cssSelector("#c240_password")).sendKeys(TestData.STUDENT_PD);

    }

    public void selectOptionWithIndex(Integer index, String selector) {
        WebElement autoOptions = driver.findElement(By.cssSelector(selector));
        wait.until(ExpectedConditions.visibilityOf(autoOptions));

        List<WebElement> optionsToSelect = autoOptions.findElements(By.tagName("div"));
        if(optionsToSelect.size() > 0)
            optionsToSelect.get(index).click();

    }

}
