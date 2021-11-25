package ru.itis.safiullin.miniplan.hw3.test;

import org.junit.Test;
import ru.itis.safiullin.miniplan.hw3.data.AccountData;
import ru.itis.safiullin.miniplan.hw3.data.TaskData;

public class AddTask extends TestBase {
    @Test
    public void testAddTask() throws Exception {
        AccountData accountData = new AccountData("oprosi902@mail.ru", "1c7372Bd");
        TaskData taskData = new TaskData("Новое дело!");
        applicationManager.getNavigationHelper().openHomePage();
        applicationManager.getNavigationHelper().openLoginPage();
        applicationManager.getLoginHelper().login(accountData);
        applicationManager.getNavigationHelper().openAddTaskPage();
        applicationManager.getAddTaskHelper().addTask(taskData);
    }
}
