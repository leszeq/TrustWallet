package tests;

import org.testng.annotations.*;
import utils.DriverUtils;

public abstract class BaseTest {
    @BeforeMethod
    public void setUp() {
        DriverUtils.initializeDriver();
    }

    @AfterMethod
    public void tearDown() {
        DriverUtils.quitDriver();
    }
}
