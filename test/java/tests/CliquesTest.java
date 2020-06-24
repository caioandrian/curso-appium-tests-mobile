package tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import page.BasePage;
import page.CliquesPage;
import page.MenuPage;
import suporte.BaseTest;

public class CliquesTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private CliquesPage pagina = new CliquesPage();

    @Before
    public void setUp(){
        menu.acessarCliques();
    }

    @Test
    public void deveInteragirComCliqueLongo(){
        //clique longo
        pagina.cliqueLongoPorElemento(By.xpath("//*[@text = 'Clique Longo']"));

        //verificar o texto abaixo
        assertEquals("Clique Longo", pagina.obterTextoCampo());
    }

    @Test
    public void deveInteragirComCliqueDuplo(){
        new BasePage().clicarPorTexto("Clique duplo");
        new BasePage().clicarPorTexto("Clique duplo");

        //verificar o texto abaixo
        assertEquals("Duplo Clique", pagina.obterTextoCampo());
    }
}
