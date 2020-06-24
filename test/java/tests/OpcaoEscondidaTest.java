package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import page.MenuPage;
import suporte.BaseTest;

public class OpcaoEscondidaTest extends BaseTest {

    private final MenuPage menu = new MenuPage();

    @Test
    public void deveEncontrarOpcaoEscondida(){
        //scroll down, de 90% (parte inferior da tela) ate 10% (parte superior da tela)
        //deslizamos a tela para baixo ao arrastar para cima.

        //clicar menu Opcao bem escondida
        menu.acessarOpcaoBemEscondida();

        //verificar mensagem
        assertEquals("Você achou essa opção", menu.obterMensagemAlerta());

        //sair
        menu.clicarPorTexto("OK");
    }



}
