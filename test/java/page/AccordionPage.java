package page;

import org.openqa.selenium.By;

public class AccordionPage extends BasePage{

    public void clicarOpcao1(){
        clicarPorTexto("Opção 1");
    }

    public String obterTextoDescricaoOpcao1(){
        return obterTexto(By.xpath("//*[@text='Opção 1']/../../following-sibling::android.view.ViewGroup//android.widget.TextView"));
    }
}
