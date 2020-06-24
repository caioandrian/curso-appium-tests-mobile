package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.*;

public class ExemploCalculadoraTest {

    private AndroidDriver<MobileElement> aplicativo;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
        desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        aplicativo = new AndroidDriver(remoteUrl, desiredCapabilities);
    }

    @Test
    public void deveSomarDoisValores() {
        MobileElement el3 = aplicativo.findElementById("com.android.calculator2:id/digit_2");
        el3.click();
        MobileElement el4 = aplicativo.findElementByAccessibilityId("plus");
        el4.click();
        MobileElement el5 = aplicativo.findElementById("com.android.calculator2:id/digit_2");
        el5.click();
        MobileElement el6 = aplicativo.findElementById("com.android.calculator2:id/result");

        System.out.println(el6.getText());

        assertEquals("4", el6.getText());
    }

    @After
    public void tearDown() {
        aplicativo.quit();
    }
}
