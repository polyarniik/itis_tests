package ru.itis.safiullin.miniplan.hw4.test;


import org.junit.Before;
import ru.itis.safiullin.miniplan.hw4.AppManager;

public class TestBase {
    public AppManager appManager;

    @Before
    public void setUp() throws Exception {
        appManager = AppManager.getInstance();
    }

}
