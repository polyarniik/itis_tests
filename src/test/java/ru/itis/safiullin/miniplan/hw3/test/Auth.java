package ru.itis.safiullin.miniplan.hw3.test;

import org.junit.Test;
import ru.itis.safiullin.miniplan.hw3.data.AccountData;


public class Auth extends TestBase {

    @Test
    public void testAuth() throws Exception {
        AccountData accountData = new AccountData("oprosi902@mail.ru", "1c7372Bd");
        applicationManager.getNavigationHelper().openHomePage();
        applicationManager.getNavigationHelper().openLoginPage();
        applicationManager.getLoginHelper().login(accountData);
    }
}
