package ru.itis.safiullin.miniplan.hw6.helper;

import org.openqa.selenium.By;
import ru.itis.safiullin.miniplan.hw6.AppManager;
import ru.itis.safiullin.miniplan.hw6.data.AccountData;

public class LoginHelper extends HelperBase {

    public LoginHelper(AppManager applicationManager) {
        super(applicationManager);
    }

    public void login(AccountData accountData) {
        if (isLoggedIn()) {
            return;
        }
        applicationManager.getNavigationHelper().openLoginPage();
        driver.findElement(By.id("login")).click();
        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys(accountData.getEmail());
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(accountData.getPassword());
        driver.findElement(By.xpath("//button/span/span/span/span")).click();
    }

    public boolean isLoggedIn() {
        return applicationManager.isElementPresent(By.className("logout-button"));
    }
}
