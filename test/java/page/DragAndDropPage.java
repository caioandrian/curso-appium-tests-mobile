package page;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import suporte.DriverFactory;

import java.util.List;

public class DragAndDropPage extends BasePage {

    public void arrastar(String origem, String destino){
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(DriverFactory.getDriver().findElement(By.xpath("//*[@text='"+ origem +"']"))));

        MobileElement inicio = DriverFactory.getDriver().findElement(By.xpath("//*[@text='"+ origem +"']"));
        MobileElement fim = DriverFactory.getDriver().findElement(By.xpath("//*[@text='"+ destino +"']"));

        new TouchAction(DriverFactory.getDriver())
                .longPress(ElementOption.element(inicio))
                .moveTo(ElementOption.element(fim))
                .release()
                .perform();

    }

    public String[] obterLista(){
        List<MobileElement> elements = DriverFactory.getDriver().findElements(By.xpath("//android.widget.TextView"));

        String[] retorno = new String[elements.size()];

        for (int i = 0; i < elements.size(); i++) {
            retorno[i] = elements.get(i).getText();
            //System.out.println("\"" + retorno[i] + "\", ");
        }

        return retorno;
    }
}
