package ru.itis.safiullin.miniplan.hw6.test;

import org.junit.Assert;
import org.junit.Test;
import ru.itis.safiullin.miniplan.hw6.data.AccountData;

public class DeleteTask extends AuthBase {
    @Test
    public void testDeleteTask() throws Exception {
        appManager.getNavigationHelper().openAddTaskPage();
        int beforeDelete = appManager.getAddTaskHelper().getCountOfTasks();
        appManager.getDeleteTaskHelper().testDeleteTask(beforeDelete - 1);
        Thread.sleep(10000);
        Assert.assertEquals(beforeDelete - 1, appManager.getAddTaskHelper().getCountOfTasks());
    }
}
