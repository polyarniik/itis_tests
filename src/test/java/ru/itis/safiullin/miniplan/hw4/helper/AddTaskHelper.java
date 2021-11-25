package ru.itis.safiullin.miniplan.hw4.helper;

import org.openqa.selenium.By;
import ru.itis.safiullin.miniplan.hw4.AppManager;
import ru.itis.safiullin.miniplan.hw4.data.TaskData;

public class AddTaskHelper extends HelperBase {
    public AddTaskHelper(AppManager applicationManager) {
        super(applicationManager);
    }

    public void addTask(TaskData taskData) throws InterruptedException {
        driver.findElement(By.id("newTodoInput")).click();
        driver.findElement(By.id("newTodoInput")).clear();
        driver.findElement(By.id("newTodoInput")).sendKeys(taskData.getText());
        driver.findElement(By.xpath("//button/span/span/span/span")).click();
    }


    public int getCountOfTasks() {
        return driver.findElements(By.className("event")).size();
    }
}
