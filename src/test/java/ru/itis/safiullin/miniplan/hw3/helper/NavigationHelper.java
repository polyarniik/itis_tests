package ru.itis.safiullin.miniplan.hw3.helper;

import org.openqa.selenium.By;
import ru.itis.safiullin.miniplan.hw3.ApplicationManager;

public class NavigationHelper extends HelperBase {
    public String baseUrl;

    public NavigationHelper(ApplicationManager applicationManager) {
        super(applicationManager);
        this.baseUrl = applicationManager.getBaseUrl();
    }

    public void openLoginPage() {
        driver.findElement(By.linkText("Войти")).click();
    }

    public void openHomePage() {
        driver.get("https://miniplan.ru/");
    }

    public void openAddTaskPage() {
        driver.get("https://miniplan.ru/todo/");
    }
}
