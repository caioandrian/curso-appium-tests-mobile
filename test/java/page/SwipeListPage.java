package page;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import suporte.DriverFactory;

public class SwipeListPage extends BasePage{

    public void swipeElementLeft(String opcao){
        //vamos subir um nivel e pegar a div que possui esse texto
        swipeElement(DriverFactory.getDriver().findElement(By.xpath("//*[@text='"+ opcao +"']/..")), 0.1, 0.9);
    }

    public void swipeElementRight(String opcao){
        //vamos subir um nivel e pegar a div que possui esse texto
        swipeElement(DriverFactory.getDriver().findElement(By.xpath("//*[@text='"+ opcao +"']/..")), 0.9, 0.1);
    }

    public void clicarBotaoMais(){
        MobileElement botao = DriverFactory.getDriver().findElement(By.xpath("//*[@text='(+)']/.."));

        new TouchAction(DriverFactory.getDriver())
                .tap(TapOptions.tapOptions()
                .withElement(ElementOption.element(botao, -50, 0)))
                .perform();
    }
}
