package ru.itis.safiullin.miniplan.hw6.helper;

import ru.itis.safiullin.miniplan.hw6.AppManager;

public class DeleteTaskHelper extends HelperBase {

    public DeleteTaskHelper(AppManager applicationManager) {
        super(applicationManager);
    }

    public void testDeleteTask(int taskNum) {
        driver.get("https://miniplan.ru/todo/");
        applicationManager.getJs().executeScript("document.getElementsByClassName(\"control delete hidden\")[" + taskNum + "].click()");
    }
}
