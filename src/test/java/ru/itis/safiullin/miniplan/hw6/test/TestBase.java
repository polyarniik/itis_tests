package ru.itis.safiullin.miniplan.hw6.test;


import org.junit.Before;
import ru.itis.safiullin.miniplan.hw6.data.AccountData;
import ru.itis.safiullin.miniplan.hw6.AppManager;

public class TestBase {
    public AppManager appManager;

    public AccountData accountData;

    @Before
    public void setUp() throws Exception {
        appManager = AppManager.getInstance();
        setUpData();
        appManager.getNavigationHelper().openHomePage();

    }

    public void setUpData() {
        this.accountData = new AccountData(appManager.getSettings().getEmail(),
                appManager.getSettings().getPassword());
    }
}
