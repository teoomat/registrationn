package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.util.Random;

public class StepDefinitions {
    Random rdm = new Random();
    private WebDriver driver;
    private String re;

    @Given("on {string}")
    public void on(String string) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(string);

        Thread.sleep(2000);

        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
    }

    @And("has email {string}")
    public void has_email_gibberish_email_com(String email) {
        try {

            driver.findElement(By.id("email")).sendKeys(email);
        } catch (Exception e) {
            System.out.println("Could not type email");
        }
    }

    @And("has username {string}")
    public void has_username(String username) {
        try {
            WebElement User = driver.findElement(By.id("new_username"));
            if (username.equals("NormalUserName")) {
                username = rdm.nextInt(1000) + username;
                User.sendKeys(username);
            } else if (username.equals("LongUserName")) {
                User.sendKeys("loremIpsumissimplydummytextoftheprintingandtypesettingindustryloremIpsumhasbeentheindustrysstandard123");
            } else if (username.equals("NormalUserName1")) {
                username = rdm.nextInt(1000) + username;
                User.sendKeys(username);
            } else {
                User.sendKeys("DoubleName");
            }
        } catch (Exception e) {
            System.out.println("Could not type username");
        }
    }

    @And("has password {string}")
    public void has_password(String password) throws InterruptedException {
        try {
            driver.findElement(By.id("new_password")).sendKeys(password);
        } catch (Exception e) {
            System.out.println("Could not click \"Sign Up\" button");
        }
        Thread.sleep(2000);
    }

    @Then("has submitted request")
    public void has_submitted() throws InterruptedException {
        driver.findElement(By.id("create-account")).click();
        Thread.sleep(2000);
    }

    @And("has {string}")
    public void get(String test) throws ElementClickInterceptedException {
        try {
            if (test.equals("Tf1")) {
                re = driver.findElement(By.className("!margin-bottom--lv3 no-transform center-on-medium")).getText();
            } else if (test.equals("Tf2")) {
                re = driver.findElement(By.className("invalid-error")).getText();
            } else if (test.equals("Tf3")) {
                re = driver.findElement(By.className("invalid-error")).getText();
            } else {
                re = driver.findElement(By.className("invalid-error")).getText();
            }
        } catch (Exception e) {
            System.out.println("Could not get " + test);
        }
        assertEquals(test, re);

        driver.quit();
    }
}
