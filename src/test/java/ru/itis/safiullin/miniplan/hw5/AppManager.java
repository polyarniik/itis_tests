package ru.itis.safiullin.miniplan.hw5;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.itis.safiullin.miniplan.hw5.helper.AddTaskHelper;
import ru.itis.safiullin.miniplan.hw5.helper.DeleteTaskHelper;
import ru.itis.safiullin.miniplan.hw5.helper.LoginHelper;
import ru.itis.safiullin.miniplan.hw5.helper.NavigationHelper;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class AppManager {
    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors;
    private NavigationHelper navigationHelper;
    private LoginHelper loginHelper;
    private AddTaskHelper addTaskHelper;
    private DeleteTaskHelper deleteTaskHelper;
    private JavascriptExecutor js;
    private static ThreadLocal<AppManager> app = new ThreadLocal<>();

    private AppManager() {
        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver");
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        verificationErrors = new StringBuffer();
        navigationHelper = new NavigationHelper(this);
        loginHelper = new LoginHelper(this);
        addTaskHelper = new AddTaskHelper(this);
        deleteTaskHelper = new DeleteTaskHelper(this);
        js = (JavascriptExecutor) driver;
    }

    public DeleteTaskHelper getDeleteTaskHelper() {
        return deleteTaskHelper;
    }

    public void setDeleteTaskHelper(DeleteTaskHelper deleteTaskHelper) {
        this.deleteTaskHelper = deleteTaskHelper;
    }

    public static AppManager getInstance() {
        if (app.get() == null) {
            AppManager newInstance = new AppManager();
            newInstance.getNavigationHelper().openHomePage();
            app.set(newInstance);
        }
        return app.get();
    }


    public void stop() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        try {
            driver.quit();
        } catch (Exception e) {
            //ignore
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
