package ru.itis.safiullin.miniplan.hw5.helper;

import ru.itis.safiullin.miniplan.hw5.AppManager;

public class NavigationHelper extends HelperBase {
    public String baseUrl;

    public NavigationHelper(AppManager applicationManager) {
        super(applicationManager);
        this.baseUrl = applicationManager.getBaseUrl();
    }

    public void openLoginPage() {
        driver.get("https://miniplan.ru/login/");
    }

    public void openHomePage() {
        driver.get("https://miniplan.ru/");
    }

    public void openAddTaskPage() {
        driver.get("https://miniplan.ru/todo/");
    }
}
