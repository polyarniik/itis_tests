package ru.itis.safiullin.miniplan.hw6.test;

import org.junit.Assert;
import org.junit.Test;
import ru.itis.safiullin.miniplan.hw6.data.AccountData;
import ru.itis.safiullin.miniplan.hw6.data.TaskData;


public class AddTask extends AuthBase {

    @Test
    public void testAddTask() throws Exception {
        TaskData taskData = appManager.getAddTaskHelper().getDataOfFirstTask();
        int beforeAdd = appManager.getAddTaskHelper().getCountOfTasks();
        appManager.getNavigationHelper().openAddTaskPage();
        appManager.getAddTaskHelper().addTask(taskData);
        Thread.sleep(3000);
        Assert.assertEquals(beforeAdd + 1, appManager.getAddTaskHelper().getCountOfTasks());
    }


}
