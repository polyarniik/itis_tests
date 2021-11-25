package ru.itis.safiullin.miniplan.hw5.helper;

import ru.itis.safiullin.miniplan.hw5.AppManager;

public class DeleteTaskHelper extends HelperBase {

    public DeleteTaskHelper(AppManager applicationManager) {
        super(applicationManager);
    }

    public void testDeleteTask(int taskNum) {
        driver.get("https://miniplan.ru/todo/");
        applicationManager.getJs().executeScript("document.getElementsByClassName(\"control delete hidden\")[" + taskNum + "].click()");
    }
}
