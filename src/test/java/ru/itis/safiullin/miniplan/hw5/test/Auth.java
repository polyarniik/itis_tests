package ru.itis.safiullin.miniplan.hw5.test;

import org.junit.Assert;
import org.junit.Test;
import ru.itis.safiullin.miniplan.hw5.data.AccountData;


public class Auth extends TestBase {

    @Test
    public void testAuth() throws Exception {
        AccountData accountData = new AccountData("oprosi902@mail.ru", "1c7372Bd");
        appManager.getNavigationHelper().openHomePage();
        appManager.getNavigationHelper().openLoginPage();
        appManager.getLoginHelper().login(accountData);
        Assert.assertTrue(appManager.getLoginHelper().isLogoutButtonExist());
    }
}
