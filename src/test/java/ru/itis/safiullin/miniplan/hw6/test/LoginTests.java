package ru.itis.safiullin.miniplan.hw6.test;

import org.junit.Assert;
import org.junit.Test;
import ru.itis.safiullin.miniplan.hw6.order.Order;
import ru.itis.safiullin.miniplan.hw6.data.AccountData;

public class LoginTests extends TestBase{

    @Test
    @Order(order = 1)
    public void loginWithInvalidData() {

        AccountData invalidAccountData = new AccountData(accountData.getEmail(), "47832748234832");
        appManager.getNavigationHelper().openLoginPage();
        appManager.getNavigationHelper().openHomePage();
        appManager.getNavigationHelper().openLoginPage();
        appManager.getLoginHelper().login(invalidAccountData);
        Assert.assertFalse(appManager.getLoginHelper().isLoggedIn());
    }

    @Test
    @Order(order = 2)
    public void loginWithValidData() {
        appManager.getNavigationHelper().openLoginPage();
        appManager.getNavigationHelper().openHomePage();
        appManager.getNavigationHelper().openLoginPage();
        appManager.getLoginHelper().login(accountData);
        Assert.assertTrue(appManager.getLoginHelper().isLoggedIn());
    }

}
