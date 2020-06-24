package tests;

import org.junit.Test;
import page.MenuPage;
import page.AbasPage;
import suporte.BaseTest;
import static org.junit.Assert.*;

public class AbasTest extends BaseTest {

    private final MenuPage menu = new MenuPage();
    private final AbasPage abasPage = new AbasPage();

    @Test
    public void deveInteragirComAbas(){
        //acessar menu abas
        menu.acessarAbas();

        //verificar que esta na aba 1
        assertTrue(abasPage.aba1IsEnabled());

        //verificar que mensagem na aba 1
        assertEquals("Este é o conteúdo da Aba 1", abasPage.obterTextoConteudoDaAba());

        //acessar aba 2
        abasPage.clicarNaAba2();

        //verificar que esta na aba 2
        assertTrue(abasPage.aba2IsEnabled());

        //verificar que mensagem na aba 2
        assertEquals("Este é o conteúdo da Aba 2", abasPage.obterTextoConteudoDaAba());
    }

}
