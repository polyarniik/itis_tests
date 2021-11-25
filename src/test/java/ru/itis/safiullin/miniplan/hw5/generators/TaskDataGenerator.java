package ru.itis.safiullin.miniplan.hw5.generators;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;

public class TaskDataGenerator {

    public static JSONObject generateJSONArray(int count) throws InterruptedException {
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < count; i++) {
            jsonArray.put(new JSONObject().put("task", RandomStringUtils.randomAlphanumeric(32)));
        }
        JSONObject researchGroupsData = new JSONObject();
        researchGroupsData.put("tasks", jsonArray);
        return researchGroupsData;
    }

    public static void writeToFile(JSONObject jsonObject) {
        try {
            FileWriter fw = new FileWriter("src/resources/data/tasks.json");
            fw.write(jsonObject.toString(4));
            fw.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Success");
    }

    public static void main(String[] args) throws InterruptedException {
        writeToFile(generateJSONArray(1));
    }

}

