package suporte;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private static AndroidDriver<MobileElement> aplicativo;

    public static AndroidDriver<MobileElement> getDriver()  {
        if (aplicativo == null){
            createDriver();

            //createTestObjectDriver();
        }

        return aplicativo;
    }

    private static void createDriver() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("automationName", "uiautomator2");

        desiredCapabilities.setCapability("fullContextList ", "true");
        desiredCapabilities.setCapability("setWebContentsDebuggingEnabled ", "true");

        //mudamos as informacoes da app pois usaremos outra apk
        //instalaremos usando o Appium diretamente da pasta resources
        //desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
        //desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        desiredCapabilities.setCapability(MobileCapabilityType.APP,
                "C:\\Users\\caio\\IdeaProjects\\webdriver-java-appium-mobile\\src\\test\\resources\\CTAppium_1_2.apk");

        try {
            URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
            aplicativo = new AndroidDriver(remoteUrl, desiredCapabilities);
        }catch (MalformedURLException e){
            e.printStackTrace();
        }

        //espera implicita
        aplicativo.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    private static void createTestObjectDriver() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");

        //colocar no lugar do xxxx o código da sua conta no testObject!!!
        desiredCapabilities.setCapability("testobject_api_key", "xxxxx");

        //para garantir mandamos a mesma versao do appium que utilizamos
        desiredCapabilities.setCapability("appiumVersion", "1.17.1");

        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability("fullContextList ", "true");
        desiredCapabilities.setCapability("setWebContentsDebuggingEnabled ", "true");

        try {
            //enviamos as definicioes antes para o Appium, agora para a nuvem.
            URL remoteUrl = new URL("https://us1-manual.app.testobject.com/wd/hub");
            aplicativo = new AndroidDriver(remoteUrl, desiredCapabilities);
        }catch (MalformedURLException e){
            e.printStackTrace();
        }

        //espera implicita
        aplicativo.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static void killDriver(){
        if(aplicativo != null){
            aplicativo.quit();
            aplicativo = null;
        }
    }
}
