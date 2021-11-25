package ru.itis.safiullin.miniplan.hw3;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.itis.safiullin.miniplan.hw3.helper.AddTaskHelper;
import ru.itis.safiullin.miniplan.hw3.helper.LoginHelper;
import ru.itis.safiullin.miniplan.hw3.helper.NavigationHelper;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class ApplicationManager {
    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors;
    private NavigationHelper navigationHelper;
    private LoginHelper loginHelper;
    private AddTaskHelper addTaskHelper;
    private JavascriptExecutor js;

    public ApplicationManager() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/ru/itis/safiullin/miniplan/chromedriver");
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        verificationErrors = new StringBuffer();
        navigationHelper = new NavigationHelper(this);
        loginHelper = new LoginHelper(this);
        addTaskHelper = new AddTaskHelper(this);
        js = (JavascriptExecutor) driver;
    }

    public void stop() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public AddTaskHelper getAddTaskHelper() {
        return addTaskHelper;
    }

    public JavascriptExecutor getJs() {
        return js;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public StringBuffer getVerificationErrors() {
        return verificationErrors;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public LoginHelper getLoginHelper() {
        return loginHelper;
    }
}
