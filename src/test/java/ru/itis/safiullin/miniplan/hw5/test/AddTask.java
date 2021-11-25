package ru.itis.safiullin.miniplan.hw5.test;

import org.junit.Assert;
import org.junit.Test;
import ru.itis.safiullin.miniplan.hw5.data.AccountData;
import ru.itis.safiullin.miniplan.hw5.data.TaskData;


public class AddTask extends TestBase {

    @Test
    public void testAddTask() throws Exception {
        if (!appManager.getLoginHelper().isLogoutButtonExist()) {
            AccountData accountData = new AccountData("oprosi902@mail.ru", "1c7372Bd");
            appManager.getNavigationHelper().openLoginPage();
            appManager.getLoginHelper().login(accountData);
        }
        TaskData taskData = appManager.getAddTaskHelper().getDataOfFirstTask();
        int beforeAdd = appManager.getAddTaskHelper().getCountOfTasks();
        appManager.getNavigationHelper().openAddTaskPage();
        appManager.getAddTaskHelper().addTask(taskData);
        Thread.sleep(3000);
        Assert.assertEquals(beforeAdd + 1, appManager.getAddTaskHelper().getCountOfTasks());
    }


}
