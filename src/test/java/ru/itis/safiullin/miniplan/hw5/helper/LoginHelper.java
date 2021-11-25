package ru.itis.safiullin.miniplan.hw5.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import ru.itis.safiullin.miniplan.hw5.AppManager;
import ru.itis.safiullin.miniplan.hw5.data.AccountData;

public class LoginHelper extends HelperBase {

    public LoginHelper(AppManager applicationManager) {
        super(applicationManager);
    }

    public void login(AccountData accountData) {
        driver.findElement(By.id("login")).click();
        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys(accountData.getEmail());
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(accountData.getPassword());
        driver.findElement(By.xpath("//button/span/span/span/span")).click();
    }

    public boolean isLogoutButtonExist() {
        try {
          driver.findElement(By.className("logout-button"));
          return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
