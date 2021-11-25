package ru.itis.safiullin.miniplan.hw3.helper;

import org.openqa.selenium.By;
import ru.itis.safiullin.miniplan.hw3.ApplicationManager;
import ru.itis.safiullin.miniplan.hw3.data.AccountData;

public class LoginHelper extends HelperBase {

    public LoginHelper(ApplicationManager applicationManager) {
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
}
