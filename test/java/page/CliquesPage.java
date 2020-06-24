package page;

import org.openqa.selenium.By;
import suporte.DriverFactory;

public class CliquesPage extends BasePage{

    public String obterTextoCampo(){
        String valorXpath = "(//android.widget.TextView)[3]";

        //usamos "(.......)" para procurar todos os elementos que possuem essa classe
        //deixando todas ocorrencias em mesmo nivel/camada e retornando a terceira ocorrencia,
        return DriverFactory.getDriver().findElement(By.xpath(valorXpath)).getText();
    }

}
