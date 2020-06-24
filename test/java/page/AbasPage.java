package page;

import org.openqa.selenium.By;

public class AbasPage extends BasePage{

    public boolean aba1IsEnabled(){
        return isEnabled(By.xpath("//android.widget.TextView[@text = 'ABA 1']"));
    }

    public boolean aba2IsEnabled(){
        return isEnabled(By.xpath("//android.widget.TextView[@text = 'ABA 2']"));
    }

    public String obterTextoConteudoDaAba(){
        return obterTexto(By.xpath("//android.support.v4.view.ViewPager//android.widget.TextView"));
    }

    public void clicarNaAba1(){
        clicarPorTexto("ABA 1");
    }

    public void clicarNaAba2(){
        clicarPorTexto("ABA 2");
    }

}
