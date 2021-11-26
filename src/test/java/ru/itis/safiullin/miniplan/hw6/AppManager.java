package ru.itis.safiullin.miniplan.hw6;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.itis.safiullin.miniplan.hw6.helper.AddTaskHelper;
import ru.itis.safiullin.miniplan.hw6.helper.DeleteTaskHelper;
import ru.itis.safiullin.miniplan.hw6.helper.LoginHelper;
import ru.itis.safiullin.miniplan.hw6.helper.NavigationHelper;
import ru.itis.safiullin.miniplan.hw6.settings.Settings;

import java.io.*;
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
    private Settings settings;

    public Settings getSettings() {
        return settings;
    }

    private AppManager() throws IOException {
        File file = new File("src/resources/settings.xml");
        XmlMapper xmlMapper = new XmlMapper();
        String xml = inputStreamToString(new FileInputStream(file));
        this.settings = xmlMapper.readValue(xml, Settings.class);
        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver");
        driver = new ChromeDriver();
        baseUrl = settings.getBaseUrl();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        verificationErrors = new StringBuffer();
        navigationHelper = new NavigationHelper(this);
        loginHelper = new LoginHelper(this);
        addTaskHelper = new AddTaskHelper(this);
        deleteTaskHelper = new DeleteTaskHelper(this);
        js = (JavascriptExecutor) driver;

    }

    public String inputStreamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }

    public DeleteTaskHelper getDeleteTaskHelper() {
        return deleteTaskHelper;
    }

    public void setDeleteTaskHelper(DeleteTaskHelper deleteTaskHelper) {
        this.deleteTaskHelper = deleteTaskHelper;
    }

    public static AppManager getInstance() throws IOException {
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

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
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
