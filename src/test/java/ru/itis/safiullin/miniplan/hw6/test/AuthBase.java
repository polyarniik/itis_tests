package ru.itis.safiullin.miniplan.hw6.test;

import ru.itis.safiullin.miniplan.hw6.data.AccountData;

public class AuthBase extends TestBase{
    @Override
    public void setUp() throws Exception {
        super.setUp();
        appManager.getLoginHelper().login(new AccountData( "oprosi902@mail.ru", "1c7372Bd"));
    }
}
