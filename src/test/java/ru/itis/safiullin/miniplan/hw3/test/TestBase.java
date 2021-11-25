package ru.itis.safiullin.miniplan.hw3.test;


import org.junit.After;
import org.junit.Before;
import ru.itis.safiullin.miniplan.hw3.ApplicationManager;

public class TestBase {
    public ApplicationManager applicationManager;


    @Before
    public void setUp() throws Exception {
        applicationManager = new ApplicationManager();
    }


    @After
    public void tearDown() throws Exception {
        applicationManager.stop();

    }

}
