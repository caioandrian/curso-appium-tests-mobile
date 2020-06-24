package page;

import org.openqa.selenium.By;

public class AlertaPage extends BasePage{

    public void clicarAlertaConfirm(){
        clicarPorTexto("ALERTA CONFIRM");
    }

    public void clicarAlertaSimples(){
        clicarPorTexto("ALERTA SIMPLES");
    }

    public void clicarAlertaRestritivo(){
        clicarPorTexto("ALERTA RESTRITIVO");
    }

    public void confirmar(){
        clicarPorTexto("CONFIRMAR");
    }

    public void sair(){
        clicarPorTexto("SAIR");
    }

    public void clicarForaDaCaixa(){
        tap(100, 150);
    }
}
