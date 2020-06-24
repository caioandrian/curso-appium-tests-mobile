package tests;

import org.junit.Test;
import page.AccordionPage;
import page.MenuPage;
import suporte.BaseTest;
import static org.junit.Assert.*;

public class AccordionTest extends BaseTest {

    private final MenuPage menu = new MenuPage();
    private final AccordionPage pagina = new AccordionPage();

    @Test
    public void deveInteragirComAccordion(){
        //acessar menu Accordion
        menu.acessarAccordion();

        //clicar na opcao 1
        pagina.clicarOpcao1();

        //espera explicita de 1seg pois o accordion possui uma animacao para abrir o texto
        esperar(1000);

        //verificar se o texto apresentado é igual o esperado
        assertEquals("Esta é a descrição da opção 1", pagina.obterTextoDescricaoOpcao1());
    }
}
