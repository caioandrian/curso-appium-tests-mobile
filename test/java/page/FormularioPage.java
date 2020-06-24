package page;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import suporte.DriverFactory;

public class FormularioPage extends BasePage{

    public void escreverNome(String nome){
        escrever(MobileBy.AccessibilityId("nome"), nome);
    }

    public String obterNome(){
        return obterTexto(MobileBy.AccessibilityId("nome"));
    }

    public void selecionarCombo(String valor){
       selecionarCombo(MobileBy.AccessibilityId("console"), valor);
    }

    public String obterValorDoCombo(){
        return obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
    }

    public void clicarNoSeekBar(double posicao){
        MobileElement seek = DriverFactory.getDriver().findElement(MobileBy.AccessibilityId("slid"));

        //diferenca entre espaco do elemento e a tela
        int delta = 50;

        int xInicial = seek.getLocation().x + delta;

        int x = (int) (xInicial + (seek.getSize().width-2*delta)*posicao);

        int y = (seek.getLocation().y) + (seek.getSize().height/2);

        tap(x, y);
    }

    public void clicarNoCheckBox(){
       clicar(By.className("android.widget.CheckBox"));
    }

    public void clicarNoSwitch(){
        clicar(MobileBy.AccessibilityId("switch"));
    }

    public boolean isCheckMarcado(){
        return isCheckMarcado(By.className("android.widget.CheckBox"));
    }

    public boolean isSwitchMarcado(){
        return isCheckMarcado(MobileBy.AccessibilityId("switch"));
    }

    public void salvarDemorado(){
        clicarPorTexto("SALVAR DEMORADO");
    }

    public void salvar(){
        clicarPorTexto("SALVAR");
    }

    public String obterNomeCadastrado(){
        return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Nome:')]"));
    }

    public String obterConsoleCadastrado(){
        return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
    }

    public String obterSwitchCadastrado(){
        return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
    }

    public String obterCheckBoxCadastrado(){
        return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));
    }

    public String obterSliderCadastrado(){
        return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Slider:')]"));
    }

}
