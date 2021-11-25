package ru.itis.safiullin.miniplan.hw5.helper;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import ru.itis.safiullin.miniplan.hw5.AppManager;
import ru.itis.safiullin.miniplan.hw5.data.TaskData;

import java.io.FileReader;
import java.io.IOException;

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

    public TaskData getDataOfFirstTask() {
        JSONParser parser = new JSONParser();
        try {
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("src/resources/data/tasks.json"));

            JSONArray jsonArray = (JSONArray) jsonObject.get("tasks");

            JSONObject taskDataJSONObject = (JSONObject) jsonArray.get(0);

            return new TaskData(
                    taskDataJSONObject.get("task").toString()
            );
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
