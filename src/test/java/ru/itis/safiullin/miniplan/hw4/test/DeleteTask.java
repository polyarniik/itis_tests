package ru.itis.safiullin.miniplan.hw4.test;

import org.junit.Assert;
import org.junit.Test;
import ru.itis.safiullin.miniplan.hw4.data.AccountData;

public class DeleteTask extends TestBase {
    @Test
    public void testDeleteTask() throws Exception {
        if (!appManager.getLoginHelper().isLogoutButtonExist()) {
            AccountData accountData = new AccountData("oprosi902@mail.ru", "1c7372Bd");
            appManager.getNavigationHelper().openLoginPage();
            appManager.getLoginHelper().login(accountData);
        }
        appManager.getNavigationHelper().openAddTaskPage();
        int beforeDelete = appManager.getAddTaskHelper().getCountOfTasks();
        appManager.getDeleteTaskHelper().testDeleteTask(beforeDelete - 1);
        Thread.sleep(10000);
        Assert.assertEquals(beforeDelete - 1, appManager.getAddTaskHelper().getCountOfTasks());
    }
}
