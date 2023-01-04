package util;

import io.cucumber.java.*;

public class hooks {

    driverFactory driverFactory = new driverFactory();
    propertiesFactory propertiesFactory = new propertiesFactory();


    @BeforeAll
    public static void beforeAll() {

    }

    @Before
    public void before() {
        driverFactory.initDriver(propertiesFactory.getBrowser());
    }

    @BeforeStep
    public void beforeStep() {
    }

    @AfterStep
    public void afterStep() {
    }

    @After
    public void after() {
        driverFactory.closeDriver();
    }

    @AfterAll
    public static void afterAll() {
    }


}
