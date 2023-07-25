package com.softwaretestingboard;

import com.softwaretestingboard.propertyreader.PropertyReader;
import com.softwaretestingboard.utilities.Utility;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends Utility {
    @Before
    public void setUp() {
        selectBrowser(PropertyReader.getInstance().getProperty("browser"));

    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}


