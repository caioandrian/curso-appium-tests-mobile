package page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import suporte.DriverFactory;

import java.util.concurrent.TimeUnit;

public class SplashPage extends BasePage{

    public boolean isTelaSplashVisivel(){
        return existeElementoPorTexto("Splash");
    }

    public void aguardarSplashSumir(){
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);

        //esperar ate que o elemento desapareca da tela (invisibilityOfElementLocated)
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@text='Splash!']")));
    }


}
