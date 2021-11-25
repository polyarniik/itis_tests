package ru.itis.safiullin.miniplan.hw3.helper;

import org.openqa.selenium.By;
import ru.itis.safiullin.miniplan.hw3.ApplicationManager;
import ru.itis.safiullin.miniplan.hw3.data.TaskData;

public class AddTaskHelper extends HelperBase {
    public AddTaskHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void addTask(TaskData taskData) {
        driver.findElement(By.id("newTodoInput")).click();
        driver.findElement(By.id("newTodoInput")).clear();
        driver.findElement(By.id("newTodoInput")).sendKeys(taskData.getText());
        driver.findElement(By.xpath("//button/span/span/span/span")).click();
    }
}
